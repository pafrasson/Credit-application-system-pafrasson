package credit.application.system.service

import credit.application.system.entity.Credit
import java.time.LocalDate
import java.util.*

interface ICreditService {
    fun save(credit : Credit): Credit
    fun findAllByCustomer (customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
    fun validDayOfInstallment(dayFirstInstallment: LocalDate): Boolean
}