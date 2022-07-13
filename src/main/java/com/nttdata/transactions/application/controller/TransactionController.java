package com.nttdata.transactions.application.controller;

import com.nttdata.transactions.infrastructure.entity.Transaction;
import com.nttdata.transactions.infrastructure.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping("/transaction")
  private Mono<Transaction> saveTransaction(@RequestBody Transaction transaction) {
    return transactionService.saveTransaction(transaction);
  }

  @GetMapping("/transaction/{id}")
  private Mono<ResponseEntity<Transaction>> findTransactinoById(@PathVariable String id) {
    return transactionService.findTransactionById(id)
      .map(transaction -> ResponseEntity.status(HttpStatus.OK).body(transaction));
  }
}
