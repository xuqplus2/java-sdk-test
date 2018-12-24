package io.tradingchain.api.account;

import java.util.List;

public class UserOffersResp {
  public Integer code;
  public String msg;
  public String cursor;
  public List<Data> data;

  public static class Data {
    public String offerId;
    public String createdAt;
    public Offer offer;
    public Offer offerP;

    @Deprecated
    private String offer_id;
    @Deprecated
    private String created_at;
    @Deprecated
    private Offer offer_p;

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
    public Data setOffer_p(Offer offer_p) {
      this.offer_p = offer_p;
      this.offerP = offer_p;
      return this;
    }

    public static class Offer {
      public String sellName;
      public String buyName;
      public String amount;
      public String price;
      public String total;
      public String fee;
    }
  }
}
