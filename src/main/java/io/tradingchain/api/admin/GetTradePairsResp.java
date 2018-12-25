package io.tradingchain.api.admin;

import java.util.List;

public class GetTradePairsResp {
  public Integer code;
  public String msg;
  public String total;
  public List<Row> rows;

  public static class Row {
    public String id;
    public String baseAssetName;
    public String counterAssetName;
    public String baseGateWay;
    public String issuerName;
    public String counterGateWay;
    public String baseIssuer;
    public String counterIssuer;
    public String baseRechargeAddr;
    public String baseWithdrawAddr;
    public String counterWithdrawAddr;
    public String counterRechargeAddr;
  }
}
