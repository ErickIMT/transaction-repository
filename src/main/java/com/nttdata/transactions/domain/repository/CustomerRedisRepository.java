package com.nttdata.transactions.domain.repository;

import com.nttdata.transactions.domain.dto.customer.Customer;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CustomerRedisRepository implements CustomerRepository{

  private ReactiveRedisOperations<String, Customer> operations;

  public CustomerRedisRepository(ReactiveRedisOperations<String, Customer> operations) {
    this.operations = operations;
  }

  @Override
  public Mono<Customer> findByCustomerId(String id) {
    return operations.opsForValue()
      .get(id)
      .map(customer -> new Customer(
        customer.getId(),
        customer.getTypeId(),
        customer.getCellphoneNumber(),
        customer.getEmail(),
        customer.getBootcoinAmount()));
  }
}
