package credit.application.system.dto

import credit.application.system.entity.Address
import credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "The field cannot be empty") val firstName: String,
    @field:NotEmpty(message = "The field cannot be empty") val lastName: String,
    @field:NotEmpty(message = "The field cannot be empty") @CPF(message = "Invalid CPF") val cpf: String,
    @field:NotNull(message = "The field cannot be null") val income: BigDecimal,
    @field:NotEmpty(message = "The field cannot be empty") @field:Email(message = "Invalid email input") val email: String,
    @field:NotEmpty(message = "The field cannot be empty") val password: String,
    @field:NotEmpty(message = "The field cannot be empty") val zipCode: String,
    @field:NotEmpty(message = "The field cannot be empty") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
