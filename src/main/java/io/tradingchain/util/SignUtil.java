package io.tradingchain.util;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {

  private static final String getPreSignStr(Map data, String secret) {
    Map<String, String> treeMap = new TreeMap<>(data);
    StringBuilder sb = new StringBuilder();
    treeMap.forEach((k, v) -> {
      if (!"sign".equals(k) && null != v) {
        sb.append("&" + k + "=" + v);
      }
    });
    sb.append("&secret=" + secret);
    return sb.toString().substring(1);
  }

  public static final void sign(Map data, String secret) throws NoSuchAlgorithmException {
    String sign = MessageDigestUtil.md5(getPreSignStr(data, secret));
    data.put("sign", sign.toLowerCase());
  }
}
