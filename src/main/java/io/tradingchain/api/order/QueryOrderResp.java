package io.tradingchain.api.order;

public class QueryOrderResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String destination;
    public String destinationAssetName;
    public String destinationAssetIssuer;
    public String destinationAmount;
    public String sourceAssetName;
    public String sourceAssetIssuer;
    public String sourceAmount;
    public String status;
    public String tradingchainNo;
    public String tradeTime;
    public String outTradeNo;
    public String notifyUrl;
    public String msg;
  }
}
