package com.nttdata.transactions.domain.repository;

import com.nttdata.transactions.domain.dto.operation.Operation;
import reactor.core.publisher.Mono;

public interface OperationRepository {

  Mono<Operation> getOperationById(String id);
}
