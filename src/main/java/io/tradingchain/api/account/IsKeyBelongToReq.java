package io.tradingchain.api.account;

import io.tradingchain.annotation.ReqParam;

public class IsKeyBelongToReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "KEY")
  public String privateKey;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public IsKeyBelongToReq(String username, String password, String privateKey) {
    this.username = username;
    this.password = password;
    this.privateKey = privateKey;
  }

  public IsKeyBelongToReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public IsKeyBelongToReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public IsKeyBelongToReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public IsKeyBelongToReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public IsKeyBelongToReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public IsKeyBelongToReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
