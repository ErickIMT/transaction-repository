package com.nttdata.transactions.infrastructure.service;

import com.nttdata.transactions.domain.dto.operation.Operation;
import com.nttdata.transactions.domain.dto.operation.TypeOperation;
import com.nttdata.transactions.domain.repository.OperationRepository;
import com.nttdata.transactions.infrastructure.entity.Transaction;
import com.nttdata.transactions.infrastructure.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Autowired
  private OperationRepository operationRepository;

  private float sell;
  private float buy;

  private Mono<Transaction> saveTransaction(Transaction transaction) {
    Mono<Operation> operation = operationRepository.getOperationById(transaction.getOperationId());
    operation.map(operation1 -> {
      transaction.setBootcoinAmount(operation1.getBootcoinAmount());
      if(transaction.getTypeOperation().equals(TypeOperation.BUY)) {
        transaction.setSolesAmount(buy * transaction.getBootcoinAmount());
      } else if(transaction.getTypeOperation().equals(TypeOperation.SELL)) {
        transaction.setSolesAmount(sell * transaction.getBootcoinAmount());
      }
      return operation1;
    });


    return transactionRepository.saveTransaction(transaction);
  }

  private Mono<Transaction> findTransactionById(String id) {
    return transactionRepository.findById(id);
  }




}
