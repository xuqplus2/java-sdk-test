package io.tradingchain.api.user;

public class IsUserExistsResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public Boolean exist;
  }
}
