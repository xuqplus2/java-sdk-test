package io.tradingchain.api.register;

public class RegisterResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public Long userId;
    public String publicKey;
    public String privateKey;
    public String backupKey;
    public String inviteCode;
  }
}
