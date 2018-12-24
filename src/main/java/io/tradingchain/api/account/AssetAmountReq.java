package io.tradingchain.api.account;

import io.tradingchain.annotation.ReqParam;

public class AssetAmountReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = true, comment = "资产名称")
  public String assetName;
  @ReqParam(nullable = true, comment = "资产发行者")
  public String assetIssuer;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public AssetAmountReq(String username, String password, String assetName, String assetIssuer) {
    this.username = username;
    this.password = password;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
  }

  public AssetAmountReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public AssetAmountReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public AssetAmountReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public AssetAmountReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public AssetAmountReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public AssetAmountReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public AssetAmountReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
