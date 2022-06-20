package br.com.apidynamodbcompleto.mordel

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import java.time.Instant


@DynamoDbBean
data class OrderModel(

    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("CustomerID")
    var customerId : String = "",

    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("OrderID")
    var orderId : String = "",

    var orderValue: Double = 0.0,

    var createdDate : Instant = Instant.now(),

    var products : MutableList<ProductModel> = mutableListOf()
    )