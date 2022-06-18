package br.com.apidynamodbcompleto.config

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    fun getDynamoDB() : AmazonDynamoDB{
        val provider = EnvironmentVariableCredentialsProvider()
        return AmazonDynamoDBClientBuilder.standard().apply {
            withCredentials(provider)
        }.build()
    }
}