package io.tradingchain.api.order;

import io.tradingchain.annotation.ReqParam;

public class RevokeOrderReq {
  @ReqParam(nullable = true, comment = "商户订单号,与tradingchain_no二选一")
  public String outTradeNo;
  @ReqParam(nullable = true, comment = "tradingchain订单号,与out_trade_no单号二选一,两者都存在,优先选择tradingchain_no")
  public String tradingchainNo;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  private RevokeOrderReq(String outTradeNo, String tradingchainNo) {
    this.outTradeNo = outTradeNo;
    this.tradingchainNo = tradingchainNo;
  }

  public static final RevokeOrderReq getInstanceByOutTradeNo(String outTradeNo) {
    return new RevokeOrderReq(outTradeNo, null);
  }

  public static final RevokeOrderReq getInstanceByTradingchainNo(String tradingchainNo) {
    return new RevokeOrderReq(null, tradingchainNo);
  }
}
