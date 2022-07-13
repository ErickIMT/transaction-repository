package com.nttdata.transactions.domain.dto.event;

import com.nttdata.transactions.domain.dto.exchange.ExchangeRate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateExchangeCreatedEvent extends Event<ExchangeRate> {

}
