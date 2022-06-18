package br.com.apidynamodbcompleto

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    fun getDynamoDB() : AmazonDynamoDB{
        val provider = EnvironmentVariableCredentialsProvider()
        return AmazonDynamoDBClientBuilder.standard()
    }
}