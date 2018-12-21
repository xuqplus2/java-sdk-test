package io.tradingchain.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilTest {

  // 测试服务器的参数
  public static final String BASE_URL = "http://api.1mfpay.com";
  public static final String API_KEY = "tradingchain";
  public static final String SECRET = "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm";

  /**
   * 以支付订单查询为例, 接口文档地址https://github.com/Tradingchain/api-service/wiki/query
   */
  @Test
  public void post() throws Exception {
    // 请求路径
    String path = "/api/query/order";

    // 输入请求参数
    Map<String, Object> data = new HashMap<>();
    data.put("outTradeNo", "xxx");
    data.put("apiKey", API_KEY);

    // 构建请求对象
    HttpUtil.Request request = new HttpUtil.Request(BASE_URL, path, data, SECRET);
    // 执行请求, 获取返回对象
    HttpUtil.Response response = HttpUtil.post(request);

    // 提供结果转换成String和Map的方法便于进行后续处理
    System.err.println(response.toMap());
    System.err.println(response.toString());

    // 后续处理
    Map map = response.toMap();
    if (0 == (int) map.get("code") && "ok".equals(map.get("msg"))) {
      // 正常响应时处理流程...
    } else {
      // 其他情况的处理流程...
    }
  }
}