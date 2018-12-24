package io.tradingchain.api.trade;

import io.tradingchain.annotation.ReqParam;

public class TradeDepthReq {
  @ReqParam(nullable = false, comment = "基础币")
  public String baseAsset;
  @ReqParam(nullable = false, comment = "基础币发行者")
  public String baseAssetIssuer;
  @ReqParam(nullable = false, comment = "计价币")
  public String counterAsset;
  @ReqParam(nullable = false, comment = "计价币发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = false, comment = "查询条目,最大值200")
  public Integer size;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public TradeDepthReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer, Integer size) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
    this.size = size;
  }

  public TradeDepthReq setBaseAsset(String baseAsset) {
    this.baseAsset = baseAsset;
    return this;
  }

  public TradeDepthReq setBaseAssetIssuer(String baseAssetIssuer) {
    this.baseAssetIssuer = baseAssetIssuer;
    return this;
  }

  public TradeDepthReq setCounterAsset(String counterAsset) {
    this.counterAsset = counterAsset;
    return this;
  }

  public TradeDepthReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public TradeDepthReq setSize(Integer size) {
    this.size = size;
    return this;
  }

  public TradeDepthReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public TradeDepthReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
