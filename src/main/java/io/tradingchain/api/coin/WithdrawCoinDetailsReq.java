package io.tradingchain.api.coin;

import io.tradingchain.annotation.ReqParam;

public class WithdrawCoinDetailsReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "c(充币)/w(提币)")
  public final String type = "w";
  @ReqParam(nullable = false, comment = "页数")
  public Integer page;
  @ReqParam(nullable = false, comment = "行数")
  public Integer rows;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public WithdrawCoinDetailsReq(String username, String password, Integer page, Integer rows) {
    this.username = username;
    this.password = password;
    this.page = page;
    this.rows = rows;
  }

  public WithdrawCoinDetailsReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public WithdrawCoinDetailsReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public WithdrawCoinDetailsReq setPage(Integer page) {
    this.page = page;
    return this;
  }

  public WithdrawCoinDetailsReq setRows(Integer rows) {
    this.rows = rows;
    return this;
  }

  public WithdrawCoinDetailsReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public WithdrawCoinDetailsReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public WithdrawCoinDetailsReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
