package io.tradingchain.util;

import com.alibaba.fastjson.JSON;
import io.tradingchain.annotation.ReqParam;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AnnotationUtil {

  public static final HttpUtil.Request buildReq(String url, Object req, String secret) throws Exception {
    Class clazz = req.getClass();
    Field[] fields = clazz.getDeclaredFields();
    Map<String, Object> data = new HashMap<>();
    for (Field field : fields) {
      ReqParam reqParam = field.getAnnotation(ReqParam.class);
      // 不能为空的, 需要手动填写的参数
      if (null != reqParam && !reqParam.nullable() && reqParam.userset()) {
        if (null == field.get(req) || "".equals(field.get(req))) {
          throw new Exception(String.format("请求对象[%s]的%s字段不能为空", clazz.getName(), null == reqParam.comment() ? field.getName() : String.format("%s[%s]", reqParam.comment(), field.getName())));
        }
      }
      if (null != field.get(req))
        data.put(field.getName(), field.get(req) instanceof String ? field.get(req) : JSON.toJSONString(field.get(req)));
    }
    return new HttpUtil.Request(url, data, secret);
  }
}
