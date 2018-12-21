package io.tradingchain.api.password;

import io.tradingchain.annotation.ReqParam;

public class ModifyPasswordReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "旧密码")
  public String password;
  @ReqParam(nullable = false, comment = "新密码")
  public String newPassword;
  @ReqParam(nullable = false, comment = "密码类型: 登陆密码（P），交易密码（T）")
  public String type;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public ModifyPasswordReq(String username, String password, String newPassword) {
    this.username = username;
    this.password = password;
    this.newPassword = newPassword;
  }

  public ModifyPasswordReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public ModifyPasswordReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public ModifyPasswordReq setNewPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  public ModifyPasswordReq setType(String type) {
    this.type = type;
    return this;
  }

  public ModifyPasswordReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public ModifyPasswordReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public ModifyPasswordReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
