package io.tradingchain.api.coin;

import java.util.List;

public class ChargeCoinDetailsResp {
  public Integer code;
  public String msg;
  public Data data;

  public static class Data {
    public String total;
    public List<Row> rows;

    public static class Row {
      public String id;
      public String asset;
      public String fromAccount;
      public String toAccount;
      public String amount;
      public String updateTime;
      public String status;
      public String fee;
      public String type;
    }
  }
}
