package io.tradingchain.api.coin;

import io.tradingchain.annotation.ReqParam;

public class WithdrawCoinReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户密码")
  public String password;
  @ReqParam(nullable = false, comment = "资产名称")
  public String assetName;
  @ReqParam(nullable = false, comment = "资产发行者")
  public String assetIssuer;
  @ReqParam(nullable = false, comment = "来源钱包账户")
  public String fromAccount;
  @ReqParam(nullable = false, comment = "目标钱包地址")
  public String toAccount;
  @ReqParam(nullable = true, comment = "币种网关")
  public String gateWay;
  @ReqParam(nullable = false, comment = "用户手机号")
  public String phone;
  @ReqParam(nullable = false, comment = "充值数量")
  public String amount;
  @ReqParam(nullable = false, comment = "提现手续费")
  public String fee;
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

  public WithdrawCoinReq(String username, String password, String assetName, String assetIssuer, String fromAccount, String toAccount, String phone, String amount, String fee, String rechargeAddr, String withdrawAddr, String privateKey) {
    this.username = username;
    this.password = password;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.phone = phone;
    this.amount = amount;
    this.fee = fee;
    this.rechargeAddr = rechargeAddr;
    this.withdrawAddr = withdrawAddr;
    this.privateKey = privateKey;
  }

  public WithdrawCoinReq(String username, String password, String assetName, String assetIssuer, String fromAccount, String toAccount, String gateWay, String phone, String amount, String fee, String memo, String rechargeAddr, String withdrawAddr, String privateKey) {
    this.username = username;
    this.password = password;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.gateWay = gateWay;
    this.phone = phone;
    this.amount = amount;
    this.fee = fee;
    this.memo = memo;
    this.rechargeAddr = rechargeAddr;
    this.withdrawAddr = withdrawAddr;
    this.privateKey = privateKey;
  }

  public WithdrawCoinReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public WithdrawCoinReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public WithdrawCoinReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public WithdrawCoinReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public WithdrawCoinReq setFromAccount(String fromAccount) {
    this.fromAccount = fromAccount;
    return this;
  }

  public WithdrawCoinReq setToAccount(String toAccount) {
    this.toAccount = toAccount;
    return this;
  }

  public WithdrawCoinReq setGateWay(String gateWay) {
    this.gateWay = gateWay;
    return this;
  }

  public WithdrawCoinReq setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public WithdrawCoinReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public WithdrawCoinReq setFee(String fee) {
    this.fee = fee;
    return this;
  }

  public WithdrawCoinReq setMemo(String memo) {
    this.memo = memo;
    return this;
  }

  public WithdrawCoinReq setRechargeAddr(String rechargeAddr) {
    this.rechargeAddr = rechargeAddr;
    return this;
  }

  public WithdrawCoinReq setWithdrawAddr(String withdrawAddr) {
    this.withdrawAddr = withdrawAddr;
    return this;
  }

  public WithdrawCoinReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public WithdrawCoinReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public WithdrawCoinReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public WithdrawCoinReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
