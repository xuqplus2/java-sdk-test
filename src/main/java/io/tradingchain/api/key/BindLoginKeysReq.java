package io.tradingchain.api.key;

import io.tradingchain.annotation.ReqParam;

public class BindLoginKeysReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "私钥1")
  public String privateKey;
  @ReqParam(nullable = false, comment = "私钥2")
  public String backupKey;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public BindLoginKeysReq(String username, String password, String privateKey, String backupKey) {
    this.username = username;
    this.password = password;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
  }

  public BindLoginKeysReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public BindLoginKeysReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public BindLoginKeysReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public BindLoginKeysReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public BindLoginKeysReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public BindLoginKeysReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public BindLoginKeysReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
