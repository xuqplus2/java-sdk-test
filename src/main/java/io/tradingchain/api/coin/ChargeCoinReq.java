package io.tradingchain.api.coin;

import io.tradingchain.annotation.ReqParam;

public class ChargeCoinReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户交易密码")
  public String password;
  @ReqParam(nullable = false, comment = "资产名称")
  public String assetName;
  @ReqParam(nullable = false, comment = "资产发行者")
  public String assetIssuer;
  @ReqParam(nullable = true, comment = "币种网关")
  public String gateWay;
  @ReqParam(nullable = false, comment = "用户手机号")
  public String phone;
  @ReqParam(nullable = false, comment = "来源钱包账户")
  public String fromAccount;
  @ReqParam(nullable = false, comment = "目标钱包地址")
  public String toAccount;
  @ReqParam(nullable = false, comment = "充值数量")
  public String amount;
  @ReqParam(nullable = true, comment = "备注")
  public String memo;
  @ReqParam(nullable = false, comment = "充币地址")
  public String rechargeAddr;
  @ReqParam(nullable = false, comment = "提币地址")
  public String withdrawAddr;
  @ReqParam(nullable = false, comment = "用户私钥")
  public String privateKey;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public ChargeCoinReq(String username, String password, String assetName, String assetIssuer, String gateWay, String phone, String fromAccount, String toAccount, String amount, String memo, String rechargeAddr, String withdrawAddr, String privateKey) {
    this.username = username;
    this.password = password;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.gateWay = gateWay;
    this.phone = phone;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.amount = amount;
    this.memo = memo;
    this.rechargeAddr = rechargeAddr;
    this.withdrawAddr = withdrawAddr;
    this.privateKey = privateKey;
  }

  public ChargeCoinReq(String username, String password, String assetName, String assetIssuer, String phone, String fromAccount, String toAccount, String amount, String rechargeAddr, String withdrawAddr, String privateKey) {
    this.username = username;
    this.password = password;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.phone = phone;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.amount = amount;
    this.rechargeAddr = rechargeAddr;
    this.withdrawAddr = withdrawAddr;
    this.privateKey = privateKey;
  }

  public ChargeCoinReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public ChargeCoinReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public ChargeCoinReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public ChargeCoinReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public ChargeCoinReq setGateWay(String gateWay) {
    this.gateWay = gateWay;
    return this;
  }

  public ChargeCoinReq setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ChargeCoinReq setFromAccount(String fromAccount) {
    this.fromAccount = fromAccount;
    return this;
  }

  public ChargeCoinReq setToAccount(String toAccount) {
    this.toAccount = toAccount;
    return this;
  }

  public ChargeCoinReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public ChargeCoinReq setMemo(String memo) {
    this.memo = memo;
    return this;
  }

  public ChargeCoinReq setRechargeAddr(String rechargeAddr) {
    this.rechargeAddr = rechargeAddr;
    return this;
  }

  public ChargeCoinReq setWithdrawAddr(String withdrawAddr) {
    this.withdrawAddr = withdrawAddr;
    return this;
  }

  public ChargeCoinReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public ChargeCoinReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public ChargeCoinReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public ChargeCoinReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
