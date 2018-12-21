package io.tradingchain.api.register;

public class BeforeRegisterResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String privateKey;
    public String backupKey;
  }
}
