package com.nttdata.transactions.infrastructure.entity;

import com.nttdata.transactions.domain.dto.operation.TypeOperation;
import com.nttdata.transactions.domain.dto.operation.TypePay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  private String id;
  private String operationId;
  private String customerId;
  private TypeOperation typeOperation;
  private TypePay typePay;
  private float bootcoinAmount;
  private float solesAmount;
}
