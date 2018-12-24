package io.tradingchain.api.trade;

import java.util.List;

public class LatestTradesResp {
  public Integer code;
  public String msg;
  public List<Data> data;

  public static class Data {
    public String amount; // 成交数量
    public String price; // 最新成交价
    public Long tid; // 成交id
    public String time; // 成交时间
    public String type; // 方向(buy/sell)
  }
}
