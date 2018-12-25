package io.tradingchain.api.order;

import io.tradingchain.annotation.ReqParam;

public class PayOrderReq {
  @ReqParam(nullable = false, comment = "预支付会话标识")
  public String prepayId;
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(nullable = false, comment = "用户拜占庭令牌或授权码")
  public String privateKey;
  @ReqParam(nullable = false, comment = "用户公钥")
  public String source;
  @ReqParam(nullable = false, comment = "支付资产名称")
  public String sourceAssetName;
  @ReqParam(nullable = false, comment = "支付资产发行者")
  public String sourceAssetIssuer;
  @ReqParam(nullable = false, comment = "支付资产数量")
  public String sourceAmount;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public PayOrderReq(String prepayId, String username, String tradePassword, String privateKey, String source, String sourceAssetName, String sourceAssetIssuer, String sourceAmount) {
    this.prepayId = prepayId;
    this.username = username;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
    this.source = source;
    this.sourceAssetName = sourceAssetName;
    this.sourceAssetIssuer = sourceAssetIssuer;
    this.sourceAmount = sourceAmount;
  }

  public PayOrderReq setPrepayId(String prepayId) {
    this.prepayId = prepayId;
    return this;
  }

  public PayOrderReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public PayOrderReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public PayOrderReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public PayOrderReq setSource(String source) {
    this.source = source;
    return this;
  }

  public PayOrderReq setSourceAssetName(String sourceAssetName) {
    this.sourceAssetName = sourceAssetName;
    return this;
  }

  public PayOrderReq setSourceAssetIssuer(String sourceAssetIssuer) {
    this.sourceAssetIssuer = sourceAssetIssuer;
    return this;
  }

  public PayOrderReq setSourceAmount(String sourceAmount) {
    this.sourceAmount = sourceAmount;
    return this;
  }

  public PayOrderReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public PayOrderReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public PayOrderReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
