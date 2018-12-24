package io.tradingchain.api.trade;

import java.math.BigDecimal;

public class TradeDepthResp {
  public Integer code;
  public String msg;
  public Long time;
  public BigDecimal[][] asks;
  public BigDecimal[][] bids;
}
