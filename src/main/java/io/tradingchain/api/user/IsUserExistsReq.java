package io.tradingchain.api.user;

import io.tradingchain.annotation.ReqParam;

public class IsUserExistsReq {

  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public IsUserExistsReq(String username) {
    this.username = username;
  }

  public IsUserExistsReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public IsUserExistsReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public IsUserExistsReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public IsUserExistsReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
