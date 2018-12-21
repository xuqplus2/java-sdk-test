package io.tradingchain.api.login;

import io.tradingchain.annotation.ReqParam;

public class LoginReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public LoginReq(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public LoginReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public LoginReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public LoginReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public LoginReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public LoginReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
