package io.tradingchain.api.register;

import io.tradingchain.annotation.ReqParam;

public class RegisterReq {
  @ReqParam(comment = "手机号码")
  public String phone;
  @ReqParam(comment = "邀请码")
  public String inviteCode;
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "用户登陆密码")
  public String password;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = false, comment = "用户私钥1")
  public String privateKey;
  @ReqParam(nullable = false, comment = "用户私钥2")
  public String backupKey;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public RegisterReq(String username, String password, String tradePassword, String privateKey, String backupKey) {
    this.username = username;
    this.password = password;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
  }

  public RegisterReq setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public RegisterReq setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }

  public RegisterReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public RegisterReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public RegisterReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public RegisterReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public RegisterReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public RegisterReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public RegisterReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public RegisterReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
