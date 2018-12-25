package io.tradingchain.api.admin;

import io.tradingchain.annotation.ReqParam;

public class GetTradePairsReq {
  @ReqParam(nullable = false, comment = "资产名称")
  public String assetName;
  @ReqParam(nullable = false, comment = "资产发行者")
  public String issuer;
  @ReqParam(nullable = false, comment = "计价(counter)/基础(base)")
  public String type;
  @ReqParam(nullable = false, comment = "分页页数")
  public String page;
  @ReqParam(nullable = false, comment = "分页行数")
  public String rows;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public GetTradePairsReq(String assetName, String issuer, String type, Integer page, Integer rows) {
    this.assetName = assetName;
    this.issuer = issuer;
    this.type = type;
    this.page = Integer.toString(page);
    this.rows = Integer.toString(rows);
  }

  public String getAssetName() {
    return assetName;
  }

  public String getIssuer() {
    return issuer;
  }

  public String getType() {
    return type;
  }

  public String getPage() {
    return page;
  }

  public String getRows() {
    return rows;
  }

  public String getSign() {
    return sign;
  }

  public String getApiKey() {
    return apiKey;
  }
}
