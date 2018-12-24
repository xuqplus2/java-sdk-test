package io.tradingchain.api.trade;

import java.util.List;

public class GetHistoryTradesResp {
  public Integer code;
  public String msg;
  public String cursor;
  public List<Data> data;

  public static class Data {
    public String id;
    public String offerId;
    public String createdAt;
    public String baseName;
    public String counterName;
    public String baseAmount;
    public String counterAmount;
    public String fee;
    public String operationType;
    public String tradePairName;
    public String cursor;

    @Deprecated
    private String offer_id;
    @Deprecated
    private String created_at;
    @Deprecated
    private String operation_type;

    @Deprecated
    public Data setOffer_id(String offer_id) {
      this.offer_id = offer_id;
      this.offerId = offer_id;
      return this;
    }

    @Deprecated
    public Data setCreated_at(String created_at) {
      this.created_at = created_at;
      this.createdAt = created_at;
      return this;
    }

    @Deprecated
    public Data setOperation_type(String operation_type) {
      this.operation_type = operation_type;
      this.operationType = operation_type;
      return this;
    }
  }
}
