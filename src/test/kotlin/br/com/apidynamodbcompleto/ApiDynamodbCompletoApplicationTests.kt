package br.com.apidynamodbcompleto

import br.com.apidynamodbcompleto.mordel.OrderModel
import br.com.apidynamodbcompleto.mordel.ProductModel
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant

@SpringBootTest

class ApiDynamodbCompletoApplicationTests {


	@Autowired
	lateinit var orderRepository: OrderRepository
	@Test
	fun testCreateOrder() {
		val product1 = ProductModel("Television", "samsung", 112.56)
		val product2 = ProductModel("Washing Machine", "panasonic", 119.99)

		val products = mutableListOf(product1, product2)

		val order = OrderModel("ORD-010",   "CUST-001", 56.7, Instant.now(), products)

		orderRepository.save(order)
	}

	@Test
	fun testGetOrder() {
		val order = orderRepository.getOrder(orderID = "CUST-001", customerID = "ORD-010")
		println(order.products)
	}

	@Test
	fun testFindOrdersByValue() {
		val orders = orderRepository.findOrdersByValue("CUST-001", 5.0)
		println("orders " + orders.items())	}
}
