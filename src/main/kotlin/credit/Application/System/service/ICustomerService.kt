package credit.Application.System.service

import credit.Application.System.entity.Customer

interface ICustomerService {
    fun save(customer: Customer) :Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}