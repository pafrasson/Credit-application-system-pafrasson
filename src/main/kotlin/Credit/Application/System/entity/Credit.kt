package Credit.Application.System.entity


import Credit.Application.System.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit (

    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val dayFirstInstallment: LocalDate,
    val numerOfInstallments: Int = 0,
    val status: Status,
    val customer: Customer? = null,
    val id: Long? = null
)