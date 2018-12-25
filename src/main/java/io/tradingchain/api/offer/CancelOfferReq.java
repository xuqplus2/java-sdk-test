package io.tradingchain.api.offer;

import io.tradingchain.annotation.ReqParam;

public class CancelOfferReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = false, comment = "订单id")
  public Long offerId;
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

  private CancelOfferReq(String username, String tradePassword, Long offerId, String privateKey, String backupKey) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.offerId = offerId;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
  }

  public static final CancelOfferReq getInstanceByPrivateKey(String username, String tradePassword, Long offerId, String privateKey) {
    return new CancelOfferReq(username, tradePassword, offerId, privateKey, null);
  }

  public static final CancelOfferReq getInstanceByBackupKey(String username, String tradePassword, Long offerId, String backupKey) {
    return new CancelOfferReq(username, tradePassword, offerId, null, backupKey);
  }

  public CancelOfferReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public CancelOfferReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public CancelOfferReq setOfferId(Long offerId) {
    this.offerId = offerId;
    return this;
  }

  public CancelOfferReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public CancelOfferReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public CancelOfferReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public CancelOfferReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public CancelOfferReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
