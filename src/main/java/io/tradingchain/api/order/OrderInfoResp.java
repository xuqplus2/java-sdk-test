package io.tradingchain.api.order;

public class OrderInfoResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String destination;
    public String destinationAssetName;
    public String destinationAssetIssuer;
    public String destinationAmount;
  }
}
