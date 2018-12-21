package io.tradingchain.api.login;

public class LoginResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String userId;
    public String publicKey;
    public String inviteCode;
    public Boolean isOld;
  }
}
