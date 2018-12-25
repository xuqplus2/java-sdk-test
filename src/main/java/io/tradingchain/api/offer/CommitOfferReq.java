package io.tradingchain.api.offer;

import io.tradingchain.annotation.ReqParam;

public class CommitOfferReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = false, comment = "价格,支持小数点后7位")
  public String price;
  @ReqParam(nullable = false, comment = "数量,支持小数点后7位")
  public String amount;
  @ReqParam(nullable = false, comment = "基础币种")
  public String baseAssetName;
  @ReqParam(nullable = false, comment = "基础币种发行者")
  public String baseAssetIssuer;
  @ReqParam(nullable = false, comment = "计价币种")
  public String counterAssetName;
  @ReqParam(nullable = false, comment = "计价币种发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = false, comment = "买卖方向,buy(买)/sell(卖)")
  public String type;
  @ReqParam(nullable = true, comment = "用户私钥,与privateKey二选一")
  public String privateKey;
  @ReqParam(nullable = true, comment = "用户私钥,与backupKey二选一")
  public String backupKey;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  private CommitOfferReq(String username, String tradePassword, String price, String amount, String baseAssetName, String baseAssetIssuer, String counterAssetName, String counterAssetIssuer, String type, String privateKey, String backupKey) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.price = price;
    this.amount = amount;
    this.baseAssetName = baseAssetName;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAssetName = counterAssetName;
    this.counterAssetIssuer = counterAssetIssuer;
    this.type = type;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
  }

  public static final CommitOfferReq getInstanceByPrivateKey(String username, String tradePassword, String price, String amount, String baseAssetName, String baseAssetIssuer, String counterAssetName, String counterAssetIssuer, String type, String privateKey) {
    return new CommitOfferReq(username, tradePassword, price, amount, baseAssetName, baseAssetIssuer, counterAssetName, counterAssetIssuer, type, privateKey, null);
  }

  public static final CommitOfferReq getInstanceByBackupKey(String username, String tradePassword, String price, String amount, String baseAssetName, String baseAssetIssuer, String counterAssetName, String counterAssetIssuer, String type, String backupKey) {
    return new CommitOfferReq(username, tradePassword, price, amount, baseAssetName, baseAssetIssuer, counterAssetName, counterAssetIssuer, type, null, backupKey);
  }

  public CommitOfferReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public CommitOfferReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public CommitOfferReq setPrice(String price) {
    this.price = price;
    return this;
  }

  public CommitOfferReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public CommitOfferReq setBaseAssetName(String baseAssetName) {
    this.baseAssetName = baseAssetName;
    return this;
  }

  public CommitOfferReq setBaseAssetIssuer(String baseAssetIssuer) {
    this.baseAssetIssuer = baseAssetIssuer;
    return this;
  }

  public CommitOfferReq setCounterAssetName(String counterAssetName) {
    this.counterAssetName = counterAssetName;
    return this;
  }

  public CommitOfferReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public CommitOfferReq setType(String type) {
    this.type = type;
    return this;
  }

  public CommitOfferReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public CommitOfferReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public CommitOfferReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public CommitOfferReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public CommitOfferReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
