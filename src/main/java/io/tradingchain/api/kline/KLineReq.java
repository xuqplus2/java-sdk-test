package io.tradingchain.api.kline;

import io.tradingchain.annotation.ReqParam;

public class KLineReq {
  @ReqParam(nullable = false, comment = "基础币")
  public String baseAsset;
  @ReqParam(nullable = false, comment = "基础币发行者")
  public String baseAssetIssuer;
  @ReqParam(nullable = false, comment = "计价币")
  public String counterAsset;
  @ReqParam(nullable = false, comment = "计价币发行者")
  public String counterAssetIssuer;
  @ReqParam(nullable = false, comment = "日线间隔时间,毫秒,支持的值为60000(1分钟),300000(5分钟),900000(15分钟)，3600000(1小时),86400000(1天),604800000(1周)")
  public Long rangeTime;
  @ReqParam(nullable = false, comment = "开始时间")
  public Long startTime;
  @ReqParam(nullable = false, comment = "结束时间")
  public Long endTime;
  @ReqParam(nullable = true, comment = "分页链接")
  public String nextPage;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public KLineReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer, RangeTime rangeTime, Long startTime, Long endTime, String nextPage) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
    this.rangeTime = rangeTime.rangeTime;
    this.startTime = startTime;
    this.endTime = endTime;
    this.nextPage = nextPage;
  }

  public KLineReq(String baseAsset, String baseAssetIssuer, String counterAsset, String counterAssetIssuer, RangeTime rangeTime, Long startTime, Long endTime) {
    this(baseAsset, baseAssetIssuer, counterAsset, counterAssetIssuer, rangeTime, startTime, endTime, "");
  }

  public enum RangeTime {
    OneMin(1000 * 60), FiveMins(1000 * 60 * 5), FifteenMins(1000 * 60 * 15), OneHour(1000 * 60 * 60), OneDay(1000 * 60 * 60 * 24), OneWeek(1000 * 60 * 60 * 24 * 7);

    RangeTime(long rangeTime) {
      this.rangeTime = rangeTime;
    }

    public Long rangeTime;
  }

  public KLineReq setBaseAsset(String baseAsset) {
    this.baseAsset = baseAsset;
    return this;
  }

  public KLineReq setBaseAssetIssuer(String baseAssetIssuer) {
    this.baseAssetIssuer = baseAssetIssuer;
    return this;
  }

  public KLineReq setCounterAsset(String counterAsset) {
    this.counterAsset = counterAsset;
    return this;
  }

  public KLineReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public KLineReq setRangeTime(RangeTime rangeTime) {
    this.rangeTime = rangeTime.rangeTime;
    return this;
  }

  public KLineReq setStartTime(Long startTime) {
    this.startTime = startTime;
    return this;
  }

  public KLineReq setEndTime(Long endTime) {
    this.endTime = endTime;
    return this;
  }

  public KLineReq setNextPage(String nextPage) {
    this.nextPage = nextPage;
    return this;
  }

  public KLineReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public KLineReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
