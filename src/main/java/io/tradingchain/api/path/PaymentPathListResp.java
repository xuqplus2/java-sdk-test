package io.tradingchain.api.path;

import java.util.List;

public class PaymentPathListResp {
  public Integer code;
  public String msg;
  public List<Data> data;

  public static class Data {
    public String amount;
    public String balance;
    public String sourceAssetName;
    public String sourceAssetIssuer;
    public String destinationAssetName;
    public String destinationAssetIssuer;
  }
}
