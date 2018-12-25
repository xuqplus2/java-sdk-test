package io.tradingchain.api.coin;

public class WithdrawCoinResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public Long orderId;
    public String status;
  }
}
