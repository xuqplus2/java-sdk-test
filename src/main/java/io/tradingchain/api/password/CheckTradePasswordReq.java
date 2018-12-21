package io.tradingchain.api.password;

import io.tradingchain.annotation.ReqParam;

public class CheckTradePasswordReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "交易密码")
  public String password;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public CheckTradePasswordReq(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public CheckTradePasswordReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public CheckTradePasswordReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public CheckTradePasswordReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public CheckTradePasswordReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public CheckTradePasswordReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
