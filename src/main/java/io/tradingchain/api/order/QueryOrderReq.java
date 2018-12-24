package io.tradingchain.api.order;

import io.tradingchain.annotation.ReqParam;

public class QueryOrderReq {
  public String outTradeNo;
  public String tradingchainNo;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public QueryOrderReq setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
    return this;
  }

  public QueryOrderReq setTradingchainNo(String tradingchainNo) {
    this.tradingchainNo = tradingchainNo;
    return this;
  }

  public QueryOrderReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public QueryOrderReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  private QueryOrderReq() {
  }

  public static final QueryOrderReq getInstanceByOutTradeNo(String outTradeNo) {
    QueryOrderReq req = new QueryOrderReq();
    req.outTradeNo = outTradeNo;
    return req;
  }

  public static final QueryOrderReq getInstanceByTradingchainNo(String tradingchainNo) {
    QueryOrderReq req = new QueryOrderReq();
    req.tradingchainNo = tradingchainNo;
    return req;
  }
}
