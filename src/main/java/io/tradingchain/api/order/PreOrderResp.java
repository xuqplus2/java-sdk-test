package io.tradingchain.api.order;

public class PreOrderResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String prepayId;
  }
}
