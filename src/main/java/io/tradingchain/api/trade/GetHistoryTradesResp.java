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
  }
}
