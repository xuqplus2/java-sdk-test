package io.tradingchain.api.account;

import io.tradingchain.annotation.ReqParam;

public class AccountDetailsReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = true, comment = "计价币名称")
  public String counterAssetName;
  @ReqParam(nullable = true, comment = "计价币发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public AccountDetailsReq(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public AccountDetailsReq(String username, String password, String counterAssetName, String counterAssetIssuer) {
    this.username = username;
    this.password = password;
    this.counterAssetName = counterAssetName;
    this.counterAssetIssuer = counterAssetIssuer;
  }

  public AccountDetailsReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public AccountDetailsReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public AccountDetailsReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public AccountDetailsReq setCounterAssetName(String counterAssetName) {
    this.counterAssetName = counterAssetName;
    return this;
  }

  public AccountDetailsReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public AccountDetailsReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public AccountDetailsReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
