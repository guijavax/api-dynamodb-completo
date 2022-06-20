package br.com.apidynamodbcompleto.mordel

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

@DynamoDbBean
data class ProductModel (
    var name: String = "",
    var brand: String = "",
    var price : Double = 0.0
        )