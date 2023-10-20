package credit.application.system.service.impl

import credit.application.system.entity.Customer
import credit.application.system.exception.BussinessException
import credit.application.system.repository.CustomerRepository
import credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BussinessException("Id $id not found.")
        }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}

