package com.nttdata.transactions.domain.repository;

import com.nttdata.transactions.domain.dto.customer.Customer;
import reactor.core.publisher.Mono;

public interface CustomerRepository {

  Mono<Customer> findByCustomerId(String id);
}
