package io.tradingchain.api.order;

import io.tradingchain.annotation.ReqParam;

public class PreOrderReq {
  @ReqParam(nullable = false, comment = "商户订单号", userset = false)
  public String outTradeNo;
  @ReqParam(nullable = false, comment = "接收者账户", userset = false)
  public String destination;
  @ReqParam(nullable = false, comment = "接收资产名称", userset = false)
  public String destinationAssetName;
  @ReqParam(nullable = false, comment = "资产发行人", userset = false)
  public String destinationAssetIssuer;
  @ReqParam(nullable = false, comment = "接收数量,小数点后最多支持7位", userset = false)
  public String destinationAmount;
  @ReqParam(nullable = false, comment = "通知地址", userset = false)
  public String notifyUrl;
  @ReqParam(nullable = false, comment = "超时时间", userset = false)
  public Long timeExpire;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public PreOrderReq(String outTradeNo, String destination, String destinationAssetName, String destinationAssetIssuer, String destinationAmount, String notifyUrl, Long timeExpire) {
    this.outTradeNo = outTradeNo;
    this.destination = destination;
    this.destinationAssetName = destinationAssetName;
    this.destinationAssetIssuer = destinationAssetIssuer;
    this.destinationAmount = destinationAmount;
    this.notifyUrl = notifyUrl;
    this.timeExpire = timeExpire;
  }

  public PreOrderReq setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
    return this;
  }

  public PreOrderReq setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  public PreOrderReq setDestinationAssetName(String destinationAssetName) {
    this.destinationAssetName = destinationAssetName;
    return this;
  }

  public PreOrderReq setDestinationAssetIssuer(String destinationAssetIssuer) {
    this.destinationAssetIssuer = destinationAssetIssuer;
    return this;
  }

  public PreOrderReq setDestinationAmount(String destinationAmount) {
    this.destinationAmount = destinationAmount;
    return this;
  }

  public PreOrderReq setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
    return this;
  }

  public PreOrderReq setTimeExpire(Long timeExpire) {
    this.timeExpire = timeExpire;
    return this;
  }

  public PreOrderReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public PreOrderReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
