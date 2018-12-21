package io.tradingchain.api.key;

import io.tradingchain.annotation.ReqParam;

public class ResetKeyReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = false, comment = "用户私钥, 授权码和拜占庭令牌其中一个")
  public String privateKey;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public ResetKeyReq(String username, String tradePassword, String privateKey) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
  }

  public ResetKeyReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public ResetKeyReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public ResetKeyReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public ResetKeyReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public ResetKeyReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public ResetKeyReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
