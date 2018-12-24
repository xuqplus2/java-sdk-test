package io.tradingchain.api.trade;

import io.tradingchain.annotation.ReqParam;

public class GetHistoryTradesReq {
  @ReqParam(nullable = false, comment = "基础币")
  public String baseAsset;
  @ReqParam(nullable = false, comment = "基础币发行者")
  public String baseAssetIssuer;
  @ReqParam(nullable = false, comment = "计价币")
  public String counterAsset;
  @ReqParam(nullable = false, comment = "计价币发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = false, comment = "排序(\"ASC\",\"DESC\")")
  public String order;
  @ReqParam(comment = "分页,传响应的cursor值,可查询下一页")
  public String cursor;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public GetHistoryTradesReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer, String order, String cursor) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
    this.order = order;
    this.cursor = cursor;
  }

  public GetHistoryTradesReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer, String order) {
    this(baseAsset, baseAssetIssuer, counterAsset, counterAssetIssuer, order, "");
  }

  public GetHistoryTradesReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer) {
    this(baseAsset, baseAssetIssuer, counterAsset, counterAssetIssuer, "DESC", "");
  }

  public GetHistoryTradesReq setBaseAsset(String baseAsset) {
    this.baseAsset = baseAsset;
    return this;
  }

  public GetHistoryTradesReq setBaseAssetIssuer(String baseAssetIssuer) {
    this.baseAssetIssuer = baseAssetIssuer;
    return this;
  }

  public GetHistoryTradesReq setCounterAsset(String counterAsset) {
    this.counterAsset = counterAsset;
    return this;
  }

  public GetHistoryTradesReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public GetHistoryTradesReq setOrder(String order) {
    this.order = order;
    return this;
  }

  public GetHistoryTradesReq setCursor(String cursor) {
    this.cursor = cursor;
    return this;
  }

  public GetHistoryTradesReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public GetHistoryTradesReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
