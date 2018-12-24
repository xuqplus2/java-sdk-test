package io.tradingchain.api.account;

public class IsKeyBelongToResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public Boolean belong;
  }
}
