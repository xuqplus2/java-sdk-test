package io.tradingchain.api.admin;

import java.util.List;

public class GetAssetsResp {
  public String total;
  public List<Row> rows;

  public static class Row {
    public String id;
    public String assetName;
    public String issuer;
    public String total;
    public String rechargeAddr;
    public String withdrawAddr;
    public String info;
    public String minFee;
    public String maxFee;
    public String minEntity;
    public String gateWay;
    public String version;
    public String createTime;
    public String updateTime;
    public String memo;
  }
}
