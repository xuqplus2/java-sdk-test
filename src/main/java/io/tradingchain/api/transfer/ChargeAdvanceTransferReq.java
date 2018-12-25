package io.tradingchain.api.transfer;

import io.tradingchain.annotation.ReqParam;

public class ChargeAdvanceTransferReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = true, comment = "用户私钥,与privateKey二选一")
  public String privateKey;
  @ReqParam(nullable = true, comment = "用户私钥,与backupKey二选一")
  public String backupKey;
  @ReqParam(nullable = true, comment = "资产数量")
  public String amount;
  @ReqParam(nullable = true, comment = "资产名称")
  public String assetName;
  @ReqParam(nullable = true, comment = "资产发行者")
  public String assetIssuer;
  @ReqParam(nullable = true, comment = "对方帐户")
  public String destination;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  private ChargeAdvanceTransferReq(String username, String tradePassword, String privateKey, String backupKey, String amount, String assetName, String assetIssuer, String destination) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
    this.amount = amount;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.destination = destination;
  }

  public static final ChargeAdvanceTransferReq getInstanceByPrivateKey(String username, String tradePassword, String privateKey, String amount, String assetName, String assetIssuer, String destination) {
    return new ChargeAdvanceTransferReq(username, tradePassword, privateKey, null, amount, assetName, assetIssuer, destination);
  }

  public static final ChargeAdvanceTransferReq getInstanceByBackupKey(String username, String tradePassword, String backupKey, String amount, String assetName, String assetIssuer, String destination) {
    return new ChargeAdvanceTransferReq(username, tradePassword, null, backupKey, amount, assetName, assetIssuer, destination);
  }

  public ChargeAdvanceTransferReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public ChargeAdvanceTransferReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public ChargeAdvanceTransferReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public ChargeAdvanceTransferReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public ChargeAdvanceTransferReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public ChargeAdvanceTransferReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public ChargeAdvanceTransferReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public ChargeAdvanceTransferReq setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  public ChargeAdvanceTransferReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public ChargeAdvanceTransferReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public ChargeAdvanceTransferReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
