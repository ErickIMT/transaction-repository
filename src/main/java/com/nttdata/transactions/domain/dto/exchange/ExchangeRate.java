package com.nttdata.transactions.domain.dto.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {

  private float buy;
  private float sell;
  private Date registeredDate;
}
