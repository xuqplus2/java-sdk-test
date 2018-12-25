package io.tradingchain.api;

import io.tradingchain.api.account.*;
import io.tradingchain.api.asset.AssetTrustReq;
import io.tradingchain.api.asset.AssetTrustResp;
import io.tradingchain.api.asset.AssetsTrustReq;
import io.tradingchain.api.asset.AssetsTrustResp;
import io.tradingchain.api.key.*;
import io.tradingchain.api.kline.KLineReq;
import io.tradingchain.api.kline.KLineResp;
import io.tradingchain.api.login.LoginReq;
import io.tradingchain.api.login.LoginResp;
import io.tradingchain.api.offer.*;
import io.tradingchain.api.order.QueryOrderReq;
import io.tradingchain.api.order.QueryOrderResp;
import io.tradingchain.api.password.*;
import io.tradingchain.api.register.BeforeRegisterReq;
import io.tradingchain.api.register.BeforeRegisterResp;
import io.tradingchain.api.register.RegisterReq;
import io.tradingchain.api.register.RegisterResp;
import io.tradingchain.api.trade.*;
import io.tradingchain.api.transfer.FreightCollectReq;
import io.tradingchain.api.transfer.FreightCollectResp;
import io.tradingchain.api.transfer.UserTransferHistoryReq;
import io.tradingchain.api.transfer.UserTransferHistoryResp;
import io.tradingchain.api.user.IsUserExistsReq;
import io.tradingchain.api.user.IsUserExistsResp;
import io.tradingchain.util.AnnotationUtil;
import io.tradingchain.util.HttpUtil;

import java.lang.reflect.Field;

public class ApiClient {

  // 全局参数
  public static String BASE_URL;
  public static String API_KEY;
  public static String PLATFORM;
  public static String SECRET;

  private static final ApiClient apiClient = new ApiClient();

  public static final ApiClient build(String baseUrl, String apiKey, String platform, String secret) {
    BASE_URL = baseUrl;
    API_KEY = apiKey;
    PLATFORM = platform;
    SECRET = secret;
    return apiClient;
  }

  public static final ApiClient getInstance() throws Exception {
    if (null == BASE_URL || "".equals(BASE_URL)) throw new Exception(String.format("全局参数%s未设置", "baseUrl"));
    if (null == API_KEY || "".equals(API_KEY)) throw new Exception(String.format("全局参数%s未设置", "apiKey"));
    if (null == PLATFORM || "".equals(PLATFORM)) throw new Exception(String.format("全局参数%s未设置", "platform"));
    if (null == SECRET || "".equals(SECRET)) throw new Exception(String.format("全局参数%s未设置", "secret"));
    return apiClient;
  }

  private ApiClient() {
  }

  private static final void setField(String fieldName, Object value, Object o) {
    try {
      Class clazz = o.getClass();
      Field field = clazz.getDeclaredField(fieldName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);
      if (null == field.get(o)) field.set(o, value);
      if (!accessible) field.setAccessible(false);
    } catch (NoSuchFieldException e) {

    } catch (IllegalAccessException e) {

    }
  }

  // 设置请求对象的公共参数
  private static final Object setCommonParams(Object o) {
    setField("apiKey", API_KEY, o);
    setField("platform", PLATFORM, o);
    return o;
  }

  /**
   * 注册前获取备份私钥
   *
   * @param req
   * @return
   * @throws Exception
   */
  public BeforeRegisterResp beforeRegister(BeforeRegisterReq req) throws Exception {
    final String path = "/api/getKeyBeforeRegister";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(BeforeRegisterResp.class);
  }

  /**
   * 注册接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public RegisterResp register(RegisterReq req) throws Exception {
    final String path = "/api/registUser2";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(RegisterResp.class);
  }

  /**
   * 登录接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public LoginResp login(LoginReq req) throws Exception {
    final String path = "/api/login2";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(LoginResp.class);
  }

  /**
   * 订单状态查询接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public QueryOrderResp queryOrder(QueryOrderReq req) throws Exception {
    final String path = "/api/query/order";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(QueryOrderResp.class);
  }

  /**
   * 用户是否存在接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public IsUserExistsResp isUserExists(IsUserExistsReq req) throws Exception {
    final String path = "/api/userIsExist";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(IsUserExistsResp.class);
  }

  /**
   * 修改登录密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ModifyPasswordResp modifyLoginPassword(ModifyPasswordReq req) throws Exception {
    final String path = "/api/resetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("P")), SECRET));
    return response.castTo(ModifyPasswordResp.class);
  }

  /**
   * 修改交易密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ModifyPasswordResp modifyTradePassword(ModifyPasswordReq req) throws Exception {
    final String path = "/api/resetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("T")), SECRET));
    return response.castTo(ModifyPasswordResp.class);
  }

  /**
   * 重置登录密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ResetPasswordResp resetLoginPassword(ResetPasswordReq req) throws Exception {
    final String path = "/api/forgetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("P")), SECRET));
    return response.castTo(ResetPasswordResp.class);
  }

  /**
   * 重置交易密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ResetPasswordResp resetTradePassword(ResetPasswordReq req) throws Exception {
    final String path = "/api/forgetPassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req.setType("T")), SECRET));
    return response.castTo(ResetPasswordResp.class);
  }

  /**
   * 校验交易密码接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public CheckTradePasswordResp checkTradePassword(CheckTradePasswordReq req) throws Exception {
    final String path = "/api/isTradePassword";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(CheckTradePasswordResp.class);
  }

  /**
   * 重置备份私钥接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public ResetKeyResp resetKey(ResetKeyReq req) throws Exception {
    final String path = "/api/resetKey";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(ResetKeyResp.class);
  }

  /**
   * 获取老用户备份私钥接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public GetLoginKeysResp getLoginKeys(GetLoginKeysReq req) throws Exception {
    final String path = "/api/loginKey";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(GetLoginKeysResp.class);
  }

  /**
   * 绑定备份私钥接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public BindLoginKeysResp bindLoginKeys(BindLoginKeysReq req) throws Exception {
    final String path = "/api/bindLoginKey";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(BindLoginKeysResp.class);
  }

  /**
   * 信任单个资产接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public AssetTrustResp assetTrust(AssetTrustReq req) throws Exception {
    final String path = "/find/assetTrust";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(AssetTrustResp.class);
  }

  /**
   * 资产列表信任接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public AssetsTrustResp assetsTrust(AssetsTrustReq req) throws Exception {
    final String path = "/find/assetTrustList";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(AssetsTrustResp.class);
  }

  /**
   * 获取24小时交易量接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public GetIntervalListResp getIntervalList(GetIntervalListReq req) throws Exception {
    final String path = "/find/getIntervalList";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(GetIntervalListResp.class);
  }

  /**
   * 获取历史交易接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public GetHistoryTradesResp getHistoryTrades(GetHistoryTradesReq req) throws Exception {
    final String path = "/find/history/getTrades";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(GetHistoryTradesResp.class);
  }

  /**
   * 交易深度接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public TradeDepthResp tradeDepth(TradeDepthReq req) throws Exception {
    final String path = "/find/tradeDepth";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(TradeDepthResp.class);
  }

  /**
   * 最新成交接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public LatestTradesResp latestTrades(LatestTradesReq req) throws Exception {
    final String path = "/find/trades";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(LatestTradesResp.class);
  }

  /**
   * K线接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public KLineResp kLine(KLineReq req) throws Exception {
    final String path = "/find/k_line";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(KLineResp.class);
  }

  /**
   * 账户详情接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public AccountDetailsResp accountDetails(AccountDetailsReq req) throws Exception {
    final String path = "/find/account";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(AccountDetailsResp.class);
  }

  /**
   * KEY是否属于账户接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public IsKeyBelongToResp isKeyBelongTo(IsKeyBelongToReq req) throws Exception {
    final String path = "/api/keyIsBelong";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(IsKeyBelongToResp.class);
  }

  /**
   * 帐户估值接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public AccountValuationsResp accountValuations(AccountValuationsReq req) throws Exception {
    final String path = "/find/account/valuations";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(AccountValuationsResp.class);
  }

  /**
   * 单一币种数量接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public AssetAmountResp assetAmount(AssetAmountReq req) throws Exception {
    final String path = "/find/getOneAssetAmount";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(AssetAmountResp.class);
  }

  /**
   * 用户历史交易接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public UserTradesHistoryResp userTradesHistory(UserTradesHistoryReq req) throws Exception {
    final String path = "/find/history/trades";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(UserTradesHistoryResp.class);
  }

  /**
   * 用户历史转账接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public UserTransferHistoryResp userTransferHistory(UserTransferHistoryReq req) throws Exception {
    final String path = "/find/account/payments";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(UserTransferHistoryResp.class);
  }

  /**
   * 用户当前挂单接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public UserOffersResp userOffers(UserOffersReq req) throws Exception {
    final String path = "/find/account/offers";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(UserOffersResp.class);
  }

  /**
   * 发起委托接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public CommitOfferResp commitOffer(CommitOfferReq req) throws Exception {
    final String path = "/trade/api/commitOffer";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(CommitOfferResp.class);
  }

  /**
   * 撤销委托接口
   *
   * @param req
   * @return
   * @throws Exception
   */
  public CancelOfferResp cancelOffer(CancelOfferReq req) throws Exception {
    final String path = "/trade/api/cancelOffer";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(CancelOfferResp.class);
  }

  /**
   * 转账接口(接收方扣手续费,到付)
   *
   * @param req
   * @return
   * @throws Exception
   */
  public FreightCollectResp freightCollect(FreightCollectReq req) throws Exception {
    final String path = "/trade/api/dfPayment";
    HttpUtil.Response response = HttpUtil.post(AnnotationUtil.buildReq(BASE_URL + path, setCommonParams(req), SECRET));
    return response.castTo(FreightCollectResp.class);
  }
}
