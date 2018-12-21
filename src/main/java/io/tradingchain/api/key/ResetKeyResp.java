package io.tradingchain.api.key;

public class ResetKeyResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String key;
  }
}
