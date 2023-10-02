package credit.Application.System.service

import credit.Application.System.entity.Credit
import java.util.*

interface ICreditService {
    fun save(credit : Credit): Credit
    fun findAllByCustomer (customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}