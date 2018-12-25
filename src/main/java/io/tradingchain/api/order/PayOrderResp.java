package io.tradingchain.api.order;

public class PayOrderResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String outTradeNo;
    public String amount;
    public String source;
    public String assetName;
    public String assetIssuer;
    public String tradeTime;
    public String tradingchainNo;
    public String status;
    public String msg;
  }
}
