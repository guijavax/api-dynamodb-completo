package br.com.apidynamodbcompleto.service.impl

import br.com.apidynamodbcompleto.OrderRepository
import br.com.apidynamodbcompleto.dto.GenericDTO
import br.com.apidynamodbcompleto.service.OrderService
import org.springframework.stereotype.Service


@Service
class OrderServiceImpl(val repository: OrderRepository) : OrderService {

    fun saveOrder(dto : GenericDTO) {

    }

}