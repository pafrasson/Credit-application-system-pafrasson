package credit.application.system.controller

import credit.Application.System.entity.Credit
import credit.Application.System.service.impl.CreditService
import credit.application.system.dto.CreditDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}