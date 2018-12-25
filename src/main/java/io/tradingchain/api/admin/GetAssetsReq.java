package io.tradingchain.api.admin;

import io.tradingchain.annotation.ReqParam;

public class GetAssetsReq {
  @ReqParam(nullable = false, comment = "分页页数,首页为1")
  public String page;
  @ReqParam(nullable = false, comment = "分页行数")
  public String rows;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public GetAssetsReq(Integer page, Integer rows) {
    this.page = Integer.toString(page);
    this.rows = Integer.toString(rows);
  }
}
