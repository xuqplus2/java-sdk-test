package io.tradingchain.api.account;

import java.util.List;

public class AccountDetailsResp {
  public Integer code;
  public String msg;
  public String total;
  public List<Data> data;

  public static class Data {
    public String balance;
    public String assetCode;
    public String assetIssuer;

    @Deprecated
    private String asset_code;
    @Deprecated
    private String asset_issuer;

    @Deprecated
    public Data setAsset_code(String asset_code) {
      this.asset_code = asset_code;
      this.assetCode = asset_code;
      return this;
    }

    @Deprecated
    public Data setAsset_issuer(String asset_issuer) {
      this.asset_issuer = asset_issuer;
      this.assetIssuer = asset_issuer;
      return this;
    }
  }
}
