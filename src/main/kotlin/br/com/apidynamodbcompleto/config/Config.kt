package br.com.apidynamodbcompleto.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class Config {

    @Bean
    fun getDynamoDBClient() : DynamoDbClient{
        val provider : AwsCredentialsProvider = DefaultCredentialsProvider.builder().build()
        return DynamoDbClient
            .builder()
            .region(Region.US_EAST_1)
            .credentialsProvider(provider)
            .build()
    }

    @Bean
    fun getDynamoDbEnhacedClient(): DynamoDbEnhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(getDynamoDBClient()).build()
}