package credit.application.system.dto

import credit.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "The field cannot be empty") val firstName: String,
    @field:NotEmpty(message = "The field cannot be empty") val lastName: String,
    @field:NotNull(message = "The field cannot be null") val income: BigDecimal,
    @field:NotEmpty(message = "The field cannot be empty") val zipCode: String,
    @field:NotEmpty(message = "The field cannot be empty") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode

        return customer
    }
}
