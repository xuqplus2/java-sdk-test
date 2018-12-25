package io.tradingchain.api.path;

import io.tradingchain.annotation.ReqParam;

public class DoPathPaymentReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = false, comment = "支付方资产数量")
  public String sourceAmount;
  @ReqParam(nullable = false, comment = "支付方资产名称")
  public String sourceAssetName;
  @ReqParam(nullable = false, comment = "支付方资产发行者")
  public String sourceAssetIssuer;
  @ReqParam(nullable = false, comment = "接收方资产数量")
  public String destinationAmount;
  @ReqParam(nullable = false, comment = "接收方资产名称")
  public String destinationAssetName;
  @ReqParam(nullable = false, comment = "接收方资产发行者")
  public String destinationAssetIssuer;
  @ReqParam(nullable = false, comment = "接收方帐户")
  public String destination;
  @ReqParam(nullable = true, comment = "用户私钥")
  public String privateKey;
  @ReqParam(nullable = true, comment = "用户私钥")
  public String backupKey;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  private DoPathPaymentReq(String username, String tradePassword, String sourceAmount, String sourceAssetName, String sourceAssetIssuer, String destinationAmount, String destinationAssetName, String destinationAssetIssuer, String destination, String privateKey, String backupKey) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.sourceAmount = sourceAmount;
    this.sourceAssetName = sourceAssetName;
    this.sourceAssetIssuer = sourceAssetIssuer;
    this.destinationAmount = destinationAmount;
    this.destinationAssetName = destinationAssetName;
    this.destinationAssetIssuer = destinationAssetIssuer;
    this.destination = destination;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
  }

  public static final DoPathPaymentReq getInstanceByPrivateKey(String username, String tradePassword, String sourceAmount, String sourceAssetName, String sourceAssetIssuer, String destinationAmount, String destinationAssetName, String destinationAssetIssuer, String destination, String privateKey) {
    return new DoPathPaymentReq(username, tradePassword, sourceAmount, sourceAssetName, sourceAssetIssuer, destinationAmount, destinationAssetName, destinationAssetIssuer, destination, privateKey, null);
  }

  public static final DoPathPaymentReq getInstanceByBackupKey(String username, String tradePassword, String sourceAmount, String sourceAssetName, String sourceAssetIssuer, String destinationAmount, String destinationAssetName, String destinationAssetIssuer, String destination, String backupKey) {
    return new DoPathPaymentReq(username, tradePassword, sourceAmount, sourceAssetName, sourceAssetIssuer, destinationAmount, destinationAssetName, destinationAssetIssuer, destination, null, backupKey);
  }

  public DoPathPaymentReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public DoPathPaymentReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public DoPathPaymentReq setSourceAmount(String sourceAmount) {
    this.sourceAmount = sourceAmount;
    return this;
  }

  public DoPathPaymentReq setSourceAssetName(String sourceAssetName) {
    this.sourceAssetName = sourceAssetName;
    return this;
  }

  public DoPathPaymentReq setSourceAssetIssuer(String sourceAssetIssuer) {
    this.sourceAssetIssuer = sourceAssetIssuer;
    return this;
  }

  public DoPathPaymentReq setDestinationAmount(String destinationAmount) {
    this.destinationAmount = destinationAmount;
    return this;
  }

  public DoPathPaymentReq setDestinationAssetName(String destinationAssetName) {
    this.destinationAssetName = destinationAssetName;
    return this;
  }

  public DoPathPaymentReq setDestinationAssetIssuer(String destinationAssetIssuer) {
    this.destinationAssetIssuer = destinationAssetIssuer;
    return this;
  }

  public DoPathPaymentReq setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  public DoPathPaymentReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public DoPathPaymentReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public DoPathPaymentReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public DoPathPaymentReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public DoPathPaymentReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
