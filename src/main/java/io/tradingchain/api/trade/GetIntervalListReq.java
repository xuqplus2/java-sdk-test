package io.tradingchain.api.trade;

import io.tradingchain.annotation.ReqParam;

public class GetIntervalListReq {
  @ReqParam(nullable = false, comment = "基础币")
  public String baseAsset;
  @ReqParam(nullable = false, comment = "基础币发行者")
  public String baseAssetIssuer;
  @ReqParam(nullable = false, comment = "计价币")
  public String counterAsset;
  @ReqParam(nullable = false, comment = "计价币发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public GetIntervalListReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
  }
}
