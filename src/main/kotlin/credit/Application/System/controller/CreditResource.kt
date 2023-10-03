package credit.application.system.controller

import credit.Application.System.entity.Credit
import credit.Application.System.service.impl.CreditService
import credit.application.system.dto.CreditDto
import credit.application.system.dto.CreditViewList
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String {
        val savedCredit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${savedCredit.creditCode} - Customer ${savedCredit.customer?.firstName} saved!"
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): List<CreditViewList> {
        return this.creditService.findAllByCustomer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
    }
}