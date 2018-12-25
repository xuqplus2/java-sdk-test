package io.tradingchain.api.transfer;

import java.util.List;

public class UserTransferHistoryResp {
  public Integer code;
  public String msg;
  public String cursor;
  public List<Data> data;

  public static class Data {
    public String id;
    public String type;
    public String createdAt;
    public String assetCode;
    public String from;
    public String to;
    public String amount;
    public String paymentType;
    public String fee;

    @Deprecated
    private String created_at;
    @Deprecated
    private String asset_code;
    @Deprecated
    private String payment_type;

    @Deprecated
    public Data setCreated_at(String created_at) {
      this.created_at = created_at;
      this.createdAt = created_at;
      return this;
    }

    @Deprecated
    public Data setAsset_code(String asset_code) {
      this.asset_code = asset_code;
      this.assetCode = asset_code;
      return this;
    }

    @Deprecated
    public Data setPayment_type(String payment_type) {
      this.payment_type = payment_type;
      this.paymentType = payment_type;
      return this;
    }
  }
}
