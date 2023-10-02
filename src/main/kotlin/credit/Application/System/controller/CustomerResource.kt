package credit.application.system.controller

import credit.Application.System.entity.Customer
import credit.Application.System.service.impl.CustomerService
import credit.application.system.dto.CustomerDto
import credit.application.system.dto.CustomerUpdateDto
import credit.application.system.dto.CustomerView
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun finById(@PathVariable id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUptadeDto: CustomerUpdateDto
    ): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUptadeDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)

        return CustomerView(customerUpdated)
    }
}