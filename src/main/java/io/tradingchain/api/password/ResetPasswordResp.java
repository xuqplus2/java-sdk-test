package io.tradingchain.api.password;

import io.tradingchain.api.login.LoginResp;

public class ResetPasswordResp {
  public Integer code;
  public String msg;
  public LoginResp.Data data;

  public static class Data {
    public Boolean status;
  }
}
