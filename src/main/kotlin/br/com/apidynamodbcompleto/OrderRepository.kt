package br.com.apidynamodbcompleto

import br.com.apidynamodbcompleto.mordel.OrderModel
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Expression
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.services.dynamodb.model.AttributeValue


@Repository
class OrderRepository(val dynamoDbEnhancedClient: DynamoDbEnhancedClient) {

    fun save(order : OrderModel) {
        val orderTable : DynamoDbTable<OrderModel> = getTable()
        orderTable.putItem(order)
    }

    fun getOrder(customerID : String, orderID : String) = getTable().getItem(getKey(customerID, orderID))

    fun deleteOrder(customerID : String, orderID : String) {
        getTable().deleteItem(getKey(customerID, orderID))
    }

    fun scanOrders() = getTable().scan()

    fun findOrdersByValue(customerID: String, orderValue: Double) : PageIterable<OrderModel> {
        val attributeValue = AttributeValue.builder().n(orderValue.toString()).build()
        val expressionValues : MutableMap<String, AttributeValue> = mutableMapOf()
        expressionValues.put(":value", attributeValue)
        val expression = Expression.builder().expression("orderValue > :value").expressionValues(expressionValues).build()

        val queryConditional = QueryConditional.keyEqualTo(Key.builder().partitionValue(customerID).build())

        return getTable().query{r -> r.queryConditional(queryConditional).filterExpression(expression)}
    }

    private fun getTable() : DynamoDbTable<OrderModel> {
        return dynamoDbEnhancedClient.table("Order", TableSchema.fromBean(OrderModel::class.java))
    }

    private fun getKey(customerID: String, orderID: String) =
        Key.builder().partitionValue(customerID).sortValue(orderID).build()
}