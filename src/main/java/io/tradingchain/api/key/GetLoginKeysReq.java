package io.tradingchain.api.key;

import io.tradingchain.annotation.ReqParam;

public class GetLoginKeysReq {
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

  public GetLoginKeysReq(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public GetLoginKeysReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public GetLoginKeysReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public GetLoginKeysReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public GetLoginKeysReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
