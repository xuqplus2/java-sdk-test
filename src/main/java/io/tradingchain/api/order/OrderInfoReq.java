package io.tradingchain.api.order;

import io.tradingchain.annotation.ReqParam;

public class OrderInfoReq {
  @ReqParam(nullable = false, comment = "预支付会话标识")
  public String prepayId;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public OrderInfoReq(String prepayId) {
    this.prepayId = prepayId;
  }
}
