package com.nttdata.transactions.domain.repository;

import com.nttdata.transactions.domain.dto.operation.Operation;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class OperationRedisRepository implements OperationRepository{

  private ReactiveRedisOperations<String, Operation> operations;

  public OperationRedisRepository(ReactiveRedisOperations<String, Operation> operations) {
    this.operations = operations;
  }

  @Override
  public Mono<Operation> getOperationById(String id) {
    return operations.opsForValue()
      .get(id)
      .map(operation -> new Operation(
        operation.getId(),
        operation.getCustomerId(),
        operation.getTypeOperation(),
        operation.getBootcoinAmount(),
        operation.getTypePay()
      ));
  }
}
