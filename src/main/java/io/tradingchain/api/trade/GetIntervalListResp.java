package io.tradingchain.api.trade;

public class GetIntervalListResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String low;
    public String high;
    public String volume;
    public String price;
    public String rate;
    public String open;
  }
}
