package credit.application.system.service.impl

import credit.application.system.entity.Credit
import credit.application.system.exception.BussinessException
import credit.application.system.repository.CreditRepository
import credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*

@Service
class CreditService(private val creditRepository: CreditRepository,
                    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        this.validDayOfInstallment(credit.dayFirstInstallment)
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
            this.creditRepository.findAllByCustomer(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
                ?: throw BussinessException("Credit $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("contact adm")
    }
    override fun validDayOfInstallment(dayFirstInstallment: LocalDate): Boolean{
        return if(dayFirstInstallment.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BussinessException("Date of first installment needs to be maximum 3 months before now")
    }
}