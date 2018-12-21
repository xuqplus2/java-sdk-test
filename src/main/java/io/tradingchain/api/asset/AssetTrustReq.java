package io.tradingchain.api.asset;

import io.tradingchain.annotation.ReqParam;

public class AssetTrustReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "交易密码")
  public String tradePassword;
  @ReqParam(comment = "用户私钥, 与backupKey二选一")
  public String privateKey;
  @ReqParam(comment = "用户私钥, 与privateKey二选一")
  public String backupKey;
  @ReqParam(nullable = false, comment = "资产名称")
  public String assetName;
  @ReqParam(nullable = false, comment = "资产发行者")
  public String assetIssuer;

  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public AssetTrustReq(String username, String tradePassword, String privateKey, String backupKey, String assetName, String assetIssuer) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
  }

  public AssetTrustReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public AssetTrustReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public AssetTrustReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public AssetTrustReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public AssetTrustReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public AssetTrustReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public AssetTrustReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public AssetTrustReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public AssetTrustReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
