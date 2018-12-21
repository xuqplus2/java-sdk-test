package io.tradingchain.api.register;

import io.tradingchain.annotation.ReqParam;

public class BeforeRegisterReq {
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public BeforeRegisterReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public BeforeRegisterReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
