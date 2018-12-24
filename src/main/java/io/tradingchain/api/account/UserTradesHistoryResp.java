package io.tradingchain.api.account;

import java.util.List;

public class UserTradesHistoryResp {
  public Integer code;
  public String msg;
  public String cursor;
  public List<Data> data;

  public static class Data {
    public String id;
    public String offerId;
    public String createdAt;
    public String cursor;
    public Trade trades;
    public Trade tradesP;

    @Deprecated
    private String offer_id;
    @Deprecated
    private String created_at;
    @Deprecated
    private Trade trades_p;

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
    public Data setTrades_p(Trade trades_p) {
      this.trades_p = trades_p;
      this.tradesP = trades_p;
      return this;
    }

    public static class Trade {
      public String baseName;
      public String counterName;
      public String price;
      public String amount;
      public String baseAccount;
      public String counterAccount;
      public String tradePairName;
      public String fee;
      public String sellAsset;
    }
  }
}
