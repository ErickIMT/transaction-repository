package com.nttdata.transactions.domain.service;

import com.nttdata.transactions.domain.dto.event.Event;
import com.nttdata.transactions.domain.dto.event.UpdateExchangeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExchangeEventService {

  @KafkaListener(
    topics = "${topic.bootcoin.name:exchange}",
    containerFactory = "kafkaListenerContainerFactory",
    groupId = "bootcoin")
  public void consumer(Event<?> event) {
    if (event.getClass().isAssignableFrom(UpdateExchangeCreatedEvent.class)) {
      UpdateExchangeCreatedEvent updateExchangeCreatedEvent = (UpdateExchangeCreatedEvent) event;
      log.info("Received Transaction created event .... with Id={}, data={}",
        updateExchangeCreatedEvent.getId(),
        updateExchangeCreatedEvent.getData().toString());
    }

  }
}
