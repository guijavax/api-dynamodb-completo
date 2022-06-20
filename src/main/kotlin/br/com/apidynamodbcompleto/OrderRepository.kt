package br.com.apidynamodbcompleto

import br.com.apidynamodbcompleto.mordel.OrderModel
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema


@Repository
class OrderRepository(val dynamoDbEnhancedClient: DynamoDbEnhancedClient) {

    fun save(order : OrderModel) {
        val orderTable : DynamoDbTable<OrderModel> = getTable()
        orderTable.putItem(order)
    }

    private fun getTable() : DynamoDbTable<OrderModel> {
        return dynamoDbEnhancedClient.table("Order", TableSchema.fromBean(OrderModel::class.java))
    }
}