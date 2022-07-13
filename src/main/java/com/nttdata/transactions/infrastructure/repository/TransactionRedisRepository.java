package com.nttdata.transactions.infrastructure.repository;

import com.nttdata.transactions.infrastructure.entity.Transaction;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TransactionRedisRepository implements TransactionRepository{

  private ReactiveRedisOperations<String, Transaction> operations;

  public TransactionRedisRepository(ReactiveRedisOperations<String, Transaction> operations) {
    this.operations = operations;
  }

  @Override
  public Mono<Transaction> saveTransaction(Transaction transaction) {
    transaction.setId(RandomStringUtils.randomAlphabetic(7));
    return operations.opsForValue()
      .set(transaction.getId(), transaction)
      .map(__ -> transaction);
  }

  @Override
  public Mono<Transaction> findById(String id) {
    return operations.opsForValue()
      .get(id)
      .map(transaction -> new Transaction(
        transaction.getId(),
        transaction.getOperationId(),
        transaction.getCustomerId(),
        transaction.getTypeOperation(),
        transaction.getTypePay(),
        transaction.getBootcoinAmount(),
        transaction.getSolesAmount()
      ));
  }
}
