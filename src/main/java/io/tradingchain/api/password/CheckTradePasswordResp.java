package io.tradingchain.api.password;

public class CheckTradePasswordResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public Boolean status;
  }
}
