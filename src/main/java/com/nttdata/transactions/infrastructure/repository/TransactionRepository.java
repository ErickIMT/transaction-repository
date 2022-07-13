package com.nttdata.transactions.infrastructure.repository;

import com.nttdata.transactions.infrastructure.entity.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionRepository {

  Mono<Transaction> saveTransaction(Transaction transaction);
  Mono<Transaction> findById(String id);
}
