package io.tradingchain.api.kline;

import java.math.BigDecimal;
import java.util.List;

public class KLineResp {
  public Integer code;
  public String msg;
  public String nextPage;
  public List<BigDecimal[]> data; // [时间戳,开盘价,最高价,最低价,收盘价,成交量]
}
