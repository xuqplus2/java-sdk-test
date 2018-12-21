package io.tradingchain.api.key;

public class GetLoginKeysResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String privateKey;
    public String backupKey;
  }
}
