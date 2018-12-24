package io.tradingchain.api.account;

import io.tradingchain.annotation.ReqParam;
import io.tradingchain.api.asset.AssetPair;

import java.util.ArrayList;
import java.util.List;

public class AccountValuationsReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = true, comment = "计价币名称")
  public String counterAssetName;
  @ReqParam(nullable = true, comment = "计价币发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = true, comment = "估值币种列表(默认\"[]\")")
  public List<AssetPair> list;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public AccountValuationsReq(String username, String password, String counterAssetName, String counterAssetIssuer) {
    this.username = username;
    this.password = password;
    this.counterAssetName = counterAssetName;
    this.counterAssetIssuer = counterAssetIssuer;
    this.list = new ArrayList<>();
  }

  public AccountValuationsReq addAsset(AssetPair assetPair) {
    if (null == this.list) this.list = new ArrayList<>();
    this.list.add(assetPair);
    return this;
  }

  public AccountValuationsReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public AccountValuationsReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public AccountValuationsReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public AccountValuationsReq setCounterAssetName(String counterAssetName) {
    this.counterAssetName = counterAssetName;
    return this;
  }

  public AccountValuationsReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public AccountValuationsReq setList(List<AssetPair> list) {
    this.list = list;
    return this;
  }

  public AccountValuationsReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public AccountValuationsReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
