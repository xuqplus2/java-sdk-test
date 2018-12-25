package io.tradingchain.api.coin;

public class ChargeCoinResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public Long orderId;
    public String status;
  }
}
