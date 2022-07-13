package com.nttdata.transactions.application.configuration;

import com.nttdata.transactions.domain.dto.customer.Customer;
import com.nttdata.transactions.domain.dto.operation.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class RedisConfiguration {

  @Bean
  public ReactiveRedisOperations<String, Customer> reactiveRedisCustomerOperations(ReactiveRedisConnectionFactory factory) {
    return new ReactiveRedisTemplate<String, Customer>(factory,
      RedisSerializationContext.fromSerializer(new Jackson2JsonRedisSerializer(Customer.class)));
  }

  @Bean
  public ReactiveRedisOperations<String, Operation> reactiveRedisOperationOperations(ReactiveRedisConnectionFactory factory) {
    return new ReactiveRedisTemplate<String, Operation>(factory,
      RedisSerializationContext.fromSerializer(new Jackson2JsonRedisSerializer(Operation.class)));
  }

}
