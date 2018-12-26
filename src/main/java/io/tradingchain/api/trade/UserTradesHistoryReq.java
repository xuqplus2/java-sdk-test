package io.tradingchain.api.trade;

import io.tradingchain.annotation.ReqParam;

public class UserTradesHistoryReq {
  @ReqParam(nullable = false, comment = "用户名")
  public String username;
  @ReqParam(nullable = false, comment = "用户登录密码")
  public String password;
  @ReqParam(nullable = false, comment = "查询条目,最大值200")
  public Integer size;
  @ReqParam(nullable = true, comment = "分页,将返回的cursor字段值传送过来,获取下一页200条")
  public String cursor;
  @ReqParam(nullable = true, comment = "排序(asc/desc)")
  public String order;
  @ReqParam(nullable = false, comment = "标识")
  public String platform;
  @ReqParam(nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(nullable = false, comment = "公钥")
  public String apiKey;

  public UserTradesHistoryReq(String username, String password, Integer size, String cursor, String order) {
    this.username = username;
    this.password = password;
    this.size = size;
    this.cursor = null == cursor ? "" : cursor;
    this.order = order;
  }

  public UserTradesHistoryReq(String username, String password, Integer size, String order) {
    this(username, password, size, "", order);
  }

  public UserTradesHistoryReq(String username, String password, Integer size) {
    this(username, password, size, null);
  }

  public UserTradesHistoryReq(String username, String password) {
    this(username, password, 200);
  }

  public UserTradesHistoryReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public UserTradesHistoryReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserTradesHistoryReq setSize(Integer size) {
    this.size = size;
    return this;
  }

  public UserTradesHistoryReq setCursor(String cursor) {
    this.cursor = cursor;
    return this;
  }

  public UserTradesHistoryReq setOrder(String order) {
    this.order = order;
    return this;
  }

  public UserTradesHistoryReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public UserTradesHistoryReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public UserTradesHistoryReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
