package io.tradingchain.api;

import com.alibaba.fastjson.JSON;
import io.tradingchain.api.account.*;
import io.tradingchain.api.admin.GetAssetsReq;
import io.tradingchain.api.admin.GetAssetsResp;
import io.tradingchain.api.admin.GetTradePairsReq;
import io.tradingchain.api.admin.GetTradePairsResp;
import io.tradingchain.api.asset.*;
import io.tradingchain.api.coin.*;
import io.tradingchain.api.key.*;
import io.tradingchain.api.kline.KLineReq;
import io.tradingchain.api.kline.KLineResp;
import io.tradingchain.api.login.LoginReq;
import io.tradingchain.api.login.LoginResp;
import io.tradingchain.api.offer.*;
import io.tradingchain.api.order.*;
import io.tradingchain.api.password.*;
import io.tradingchain.api.path.DoPathPaymentReq;
import io.tradingchain.api.path.DoPathPaymentResp;
import io.tradingchain.api.path.PaymentPathListReq;
import io.tradingchain.api.path.PaymentPathListResp;
import io.tradingchain.api.register.BeforeRegisterReq;
import io.tradingchain.api.register.BeforeRegisterResp;
import io.tradingchain.api.register.RegisterReq;
import io.tradingchain.api.register.RegisterResp;
import io.tradingchain.api.trade.*;
import io.tradingchain.api.transfer.*;
import io.tradingchain.api.user.IsUserExistsReq;
import io.tradingchain.api.user.IsUserExistsResp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApiClientTest {

  // 测试服务器的参数
  public static final String BASE_URL = "http://api.1mfpay.com";
  public static final String API_KEY = "tradingchain";
  public static final String PLATFORM = "tradingchain_test";
  public static final String SECRET = "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm";

  // 测试用例用到的参数
  private static final String USERNAME = "test_xx01234_dma";
  private static final String PASSWORD = "xx123456";
  private static final String TRADE_PASSWORD = "123456";
  private static final String MOCK_USER_USERNAME = "test_xx01234_nba";
  private static final String MOCK_USER_PUBLIC_KEY = "GALBWDR52HZIDKNEE4GTTBBXUUJDROBTMFM6ONZ26BTXLEKRBDRSHPNC";
  private static final String MOCK_USER_BACKUP_KEY = "SDPTX4A547RTLE3DHZKC3B5WLCGUUTXHQAHHD24DY4VIAWTNOUBXGVXP";
  private static final String MOCK_USER_PRIVATE_KEY = "SAKC3P3IOAGK2TBB3UNTWIMZDU3CIFBHIRFOPVK3VAR7ELWXRQJURKPT";
  private static final String BTC = "BTC";
  private static final String TC = "TC";
  private static final String XLM = "XLM";
  private static final String USDT = "USDT";
  private static final String ISSUER = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";

  private static final String getAUsername() {
    return "test_" + System.currentTimeMillis();
  }

  @Before
  public void before() throws Exception {
    ApiClient.build(BASE_URL, API_KEY, PLATFORM, SECRET);
    createOrResetMockUser();
  }

  /**
   * 创建测试用户或重置测试用户密码
   *
   * @throws Exception
   */
  private void createOrResetMockUser() throws Exception {
    IsUserExistsResp isUserExistsResp = ApiClient.getInstance()
            .isUserExists(new IsUserExistsReq(USERNAME));
    if (isUserExistsResp.data.exist) {
      ApiClient.getInstance()
              .resetLoginPassword(new ResetPasswordReq(USERNAME, PASSWORD));
      ApiClient.getInstance()
              .resetTradePassword(new ResetPasswordReq(USERNAME, TRADE_PASSWORD));
    } else {
      BeforeRegisterResp beforeRegisterResp = ApiClient.getInstance()
              .beforeRegister(new BeforeRegisterReq());
      ApiClient.getInstance()
              .register(new RegisterReq(USERNAME, PASSWORD, TRADE_PASSWORD, beforeRegisterResp.data.privateKey, beforeRegisterResp.data.backupKey));
    }
  }

  @Test
  public void beforeRegister() throws Exception {
    BeforeRegisterResp resp = ApiClient.getInstance()
            .beforeRegister(new BeforeRegisterReq());
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code); // 返回状态码0, 成功
    Assert.assertNotNull(resp.data.backupKey); // 两个私钥不为空
    Assert.assertNotNull(resp.data.privateKey); // 两个私钥不为空
  }

  @Test
  public void register() throws Exception {
    String username = getAUsername();
    BeforeRegisterResp beforeRegisterResp = ApiClient.getInstance()
            .beforeRegister(new BeforeRegisterReq());

    RegisterResp resp = ApiClient.getInstance()
            .register(new RegisterReq(username, PASSWORD, TRADE_PASSWORD, beforeRegisterResp.data.privateKey, beforeRegisterResp.data.backupKey));
    System.err.println(JSON.toJSONString(resp));

    Assert.assertTrue(0 == resp.code);
    Assert.assertNotNull(resp.data);
  }

  @Test
  public void login() throws Exception {
    LoginResp resp = ApiClient.getInstance()
            .login(new LoginReq(USERNAME, PASSWORD));
    System.err.println(JSON.toJSONString(resp));

    Assert.assertTrue(0 == resp.code);
    Assert.assertNotNull(resp.data);
  }

  @Test
  public void isUserExists() throws Exception {
    IsUserExistsResp resp = ApiClient.getInstance()
            .isUserExists(new IsUserExistsReq(USERNAME));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue(resp.data.exist);

    String username = "one_hundred_percent_not_exists";
    resp = ApiClient.getInstance()
            .isUserExists(new IsUserExistsReq(username));
    System.err.println(JSON.toJSONString(resp));

    Assert.assertTrue(0 == resp.code);
    Assert.assertFalse(resp.data.exist);
  }

  @Test
  public void modifyLoginPassword() throws Exception {
    String newPassword = "newPassword";

    // 修改密码
    ModifyPasswordResp resp = ApiClient.getInstance()
            .modifyLoginPassword(new ModifyPasswordReq(USERNAME, PASSWORD, newPassword));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));

    // 新密码登录
    LoginResp loginResp = ApiClient.getInstance()
            .login(new LoginReq(USERNAME, newPassword));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertNotNull(loginResp.data);

    // 再修改失败
    resp = ApiClient.getInstance()
            .modifyLoginPassword(new ModifyPasswordReq(USERNAME, PASSWORD, newPassword));
    Assert.assertFalse(0 == resp.code);
    Assert.assertFalse("ok".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void modifyTradePassword() throws Exception {
    String newPassword = "666666";

    // 修改交易密码
    ModifyPasswordResp resp = ApiClient.getInstance()
            .modifyTradePassword(new ModifyPasswordReq(USERNAME, TRADE_PASSWORD, newPassword));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));

    // 校验新密码
    CheckTradePasswordResp checkTradePasswordResp = ApiClient.getInstance()
            .checkTradePassword(new CheckTradePasswordReq(USERNAME, newPassword));
    System.err.println(JSON.toJSONString(checkTradePasswordResp));
    Assert.assertTrue(0 == checkTradePasswordResp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(checkTradePasswordResp.msg));

    // 再修改失败
    resp = ApiClient.getInstance()
            .modifyTradePassword(new ModifyPasswordReq(USERNAME, TRADE_PASSWORD, newPassword));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertFalse(0 == resp.code);
    Assert.assertFalse("ok".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void resetLoginPassword() throws Exception {
    String newPassword = "newPassword";

    // 重置密码
    ResetPasswordResp resp = ApiClient.getInstance()
            .resetLoginPassword(new ResetPasswordReq(USERNAME, newPassword));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));

    // 新密码登录
    LoginResp loginResp = ApiClient.getInstance()
            .login(new LoginReq(USERNAME, newPassword));
    System.err.println(JSON.toJSONString(loginResp));
    Assert.assertTrue(0 == loginResp.code);
    Assert.assertNotNull(loginResp.data);
  }

  @Test
  public void resetTradePassword() throws Exception {
    String newPassword = "666666";

    // 重置交易密码
    ResetPasswordResp resp = ApiClient.getInstance()
            .resetTradePassword(new ResetPasswordReq(USERNAME, newPassword));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));

    // 校验新交易密码
    CheckTradePasswordResp checkTradePasswordResp = ApiClient.getInstance()
            .checkTradePassword(new CheckTradePasswordReq(USERNAME, newPassword));
    System.err.println(checkTradePasswordResp);
    Assert.assertTrue(0 == checkTradePasswordResp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(checkTradePasswordResp.msg));
  }

  @Test
  public void checkTradePassword() throws Exception {
    CheckTradePasswordResp resp = ApiClient.getInstance()
            .checkTradePassword(new CheckTradePasswordReq(USERNAME, TRADE_PASSWORD));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void resetKey() throws Exception {
    String username = getAUsername();
    BeforeRegisterResp beforeRegisterResp = ApiClient.getInstance()
            .beforeRegister(new BeforeRegisterReq());
    RegisterResp registerResp = ApiClient.getInstance()
            .register(new RegisterReq(username, PASSWORD, TRADE_PASSWORD, beforeRegisterResp.data.privateKey, beforeRegisterResp.data.backupKey));
    String backupKey = registerResp.data.backupKey;
    String privateKey = registerResp.data.privateKey;

    ResetKeyResp resp = ApiClient.getInstance()
            .resetKey(new ResetKeyReq(username, TRADE_PASSWORD, backupKey));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    String newPrivateKey = resp.data.key;
    Assert.assertNotNull(newPrivateKey);

    resp = ApiClient.getInstance()
            .resetKey(new ResetKeyReq(username, TRADE_PASSWORD, privateKey));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertFalse(0 == resp.code);
    Assert.assertFalse("ok".equalsIgnoreCase(resp.msg));
    Assert.assertNull(resp.data);

    resp = ApiClient.getInstance()
            .resetKey(new ResetKeyReq(username, TRADE_PASSWORD, newPrivateKey));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    String newBackupKey = resp.data.key;
    Assert.assertNotNull(newBackupKey);
  }

  @Test
  public void getLoginKeys() throws Exception {
    GetLoginKeysResp resp = ApiClient.getInstance()
            .getLoginKeys(new GetLoginKeysReq(USERNAME, PASSWORD));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(205 == resp.code);
    Assert.assertTrue("已设置过拜占庭令牌,不可再次设置".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void bindLoginKeys() throws Exception {
    BindLoginKeysResp resp = ApiClient.getInstance()
            .bindLoginKeys(new BindLoginKeysReq(USERNAME, PASSWORD, "xx", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void assetTrust() throws Exception {
    AssetTrustResp resp = ApiClient.getInstance()
            .assetTrust(new AssetTrustReq(MOCK_USER_USERNAME, TRADE_PASSWORD, MOCK_USER_PRIVATE_KEY, null, USDT, ISSUER));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));

    resp = ApiClient.getInstance()
            .assetTrust(AssetTrustReq.getInstanceByBackupKey(MOCK_USER_USERNAME, TRADE_PASSWORD, MOCK_USER_PRIVATE_KEY, USDT, ISSUER));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));

    resp = ApiClient.getInstance()
            .assetTrust(AssetTrustReq.getInstanceByPrivateKey(MOCK_USER_USERNAME, TRADE_PASSWORD, MOCK_USER_BACKUP_KEY, USDT, ISSUER));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void assetsTrust() throws Exception {
    AssetsTrustResp resp = ApiClient.getInstance()
            .assetsTrust(
                    new AssetsTrustReq(MOCK_USER_USERNAME, MOCK_USER_PRIVATE_KEY)
                            .addAsset(new AssetPair(USDT, ISSUER))
                            .addAsset(new AssetPair(BTC, ISSUER))
                            .addAsset(new AssetPair(TC, ""))
            );
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void getIntervalList() throws Exception {
    GetIntervalListResp resp = ApiClient.getInstance()
            .getIntervalList(new GetIntervalListReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void getHistoryTrades() throws Exception {
    GetHistoryTradesResp resp = ApiClient.getInstance()
            .getHistoryTrades(new GetHistoryTradesReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));

    System.err.println(resp.data.get(0).createdAt);
    System.err.println(resp.data.get(0).setOffer_id(""));
  }

  @Test
  public void tradeDepth() throws Exception {
    TradeDepthResp resp = ApiClient.getInstance()
            .tradeDepth(new TradeDepthReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void latestTrades() throws Exception {
    LatestTradesResp resp = ApiClient.getInstance()
            .latestTrades(new LatestTradesReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void kLine() throws Exception {
    KLineResp resp = ApiClient.getInstance()
            .kLine(new KLineReq("XRP", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", KLineReq.RangeTime.OneHour, 1535338800000L, 1535338800000L));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void accountDetails() throws Exception {
    AccountDetailsResp resp = ApiClient.getInstance()
            .accountDetails(new AccountDetailsReq(USERNAME, PASSWORD, USDT, ISSUER));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertNotNull(resp.data);

    resp = ApiClient.getInstance()
            .accountDetails(new AccountDetailsReq(USERNAME, PASSWORD));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertNotNull(resp.data);
  }

  @Test
  public void isKeyBelongTo() throws Exception {
    // 注册全新用户
    String username = getAUsername();
    BeforeRegisterResp beforeRegisterResp = ApiClient.getInstance()
            .beforeRegister(new BeforeRegisterReq());
    RegisterResp registerResp = ApiClient.getInstance()
            .register(new RegisterReq(username, PASSWORD, TRADE_PASSWORD, beforeRegisterResp.data.privateKey, beforeRegisterResp.data.backupKey));
    String backupKey = registerResp.data.backupKey;
    String privateKey = registerResp.data.privateKey;

    // 判断私钥是否是用户的
    IsKeyBelongToResp resp = ApiClient.getInstance()
            .isKeyBelongTo(new IsKeyBelongToReq(username, PASSWORD, privateKey));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertTrue(resp.data.belong);

    // 判断私钥是否是用户的
    resp = ApiClient.getInstance()
            .isKeyBelongTo(new IsKeyBelongToReq(username, PASSWORD, backupKey));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertTrue(resp.data.belong);

    // 用错误的私钥测试
    resp = ApiClient.getInstance()
            .isKeyBelongTo(new IsKeyBelongToReq(username, PASSWORD, "xx"));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertFalse(0 == resp.code);
    Assert.assertFalse("ok".equalsIgnoreCase(resp.msg));
    Assert.assertFalse(resp.data.belong);
  }

  @Test
  public void accountValuations() throws Exception {
    AccountValuationsResp resp = ApiClient.getInstance()
            .accountValuations(new AccountValuationsReq(USERNAME, PASSWORD, USDT, ISSUER));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertNotNull(resp.total);

    resp = ApiClient.getInstance()
            .accountValuations(
                    new AccountValuationsReq(USERNAME, PASSWORD, USDT, ISSUER)
                            .addAsset(new AssetPair(XLM, ISSUER))
                            .addAsset(new AssetPair(BTC, ISSUER))
            );
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertNotNull(resp.total);
  }

  @Test
  public void assetAmount() throws Exception {
    AssetAmountResp resp = ApiClient.getInstance()
            .assetAmount(new AssetAmountReq(USERNAME, PASSWORD, USDT, ISSUER));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
    Assert.assertTrue(0 == resp.amount.intValue());
  }

  @Test
  public void userTradesHistory() throws Exception {
    UserTradesHistoryResp resp = ApiClient.getInstance()
            .userTradesHistory(new UserTradesHistoryReq(USERNAME, PASSWORD));
    System.err.println(JSON.toJSONString(resp));
    Assert.assertTrue(0 == resp.code);
    Assert.assertTrue("ok".equalsIgnoreCase(resp.msg));
  }

  @Test
  public void userTransferHistory() throws Exception {
    UserTransferHistoryResp resp = ApiClient.getInstance()
            .userTransferHistory(new UserTransferHistoryReq(USERNAME, TRADE_PASSWORD, 200));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void userOffers() throws Exception {
    UserOffersResp resp = ApiClient.getInstance()
            .userOffers(new UserOffersReq("15921863921", "12345678"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void commitOffer() throws Exception {
    CommitOfferResp resp = ApiClient.getInstance()
            .commitOffer(CommitOfferReq.getInstanceByBackupKey("test", "test", "0.001", "0.001", "xx", "xx", "xx", "xx", "buy", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void cancelOffer() throws Exception {
    CancelOfferResp resp = ApiClient.getInstance()
            .cancelOffer(CancelOfferReq.getInstanceByBackupKey("test", "test", 1L, "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void freightCollectTransfer() throws Exception {
    ChargeCollectTransferResp resp = ApiClient.getInstance()
            .freightCollectTransfer(ChargeCollectTransferReq.getInstanceByBackupKey("test", "test", "xx", "0.001", "xx", "xx", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void chargeAdvanceTransfer() throws Exception {
    ChargeAdvanceTransferResp resp = ApiClient.getInstance()
            .chargeAdvanceTransfer(ChargeAdvanceTransferReq.getInstanceByBackupKey("test", "test", "xx", "0.001", "xx", "xx", "xx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void chargeCoin() throws Exception {
    ChargeCoinResp resp = ApiClient.getInstance()
            .chargeCoin(
                    new ChargeCoinReq("15921863921", "12345678", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "15921863921", "test", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "0.001", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "xx")
                            .setMemo("memo")
                            .setGateWay(BASE_URL)
            );
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void withdrawCoin() throws Exception {
    WithdrawCoinResp resp = ApiClient.getInstance()
            .withdrawCoin(
                    new WithdrawCoinReq("test", "test", "test", "test", "test", "test", "test", "1", "0.0001", "test", "test", "test")
                            .setMemo("memo")
                            .setGateWay(BASE_URL)
            );
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void chargeCoinDetails() throws Exception {
    ChargeCoinDetailsResp resp = ApiClient.getInstance()
            .chargeCoinDetails(new ChargeCoinDetailsReq("15921863921", "12345678", 1, 10));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void withdrawCoinDetails() throws Exception {
    WithdrawCoinDetailsResp resp = ApiClient.getInstance()
            .withdrawCoinDetails(new WithdrawCoinDetailsReq("15921863921", "12345678", 1, 10));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void paymentPathListOfFreightCollect() throws Exception {
    PaymentPathListResp resp = ApiClient.getInstance()
            .paymentPathListOfFreightCollect(new PaymentPathListReq("15921863921", "12345678", "1", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void paymentPathListOfChargeAdvance() throws Exception {
    PaymentPathListResp resp = ApiClient.getInstance()
            .paymentPathListOfChargeAdvance(new PaymentPathListReq("15921863921", "12345678", "1", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void doPathPaymentFreightCollect() throws Exception {
    DoPathPaymentResp resp = ApiClient.getInstance()
            .doPathPaymentFreightCollect(DoPathPaymentReq
                    .getInstanceByBackupKey("test", "test", "0.001", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "0.001", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "xxxx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void doPathPaymentChargeAdvance() throws Exception {
    DoPathPaymentResp resp = ApiClient.getInstance()
            .doPathPaymentChargeAdvance(DoPathPaymentReq
                    .getInstanceByBackupKey("test", "test", "0.001", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "0.001", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "xxxx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void getAssets() throws Exception {
    GetAssetsResp resp = ApiClient.getInstance()
            .getAssets(new GetAssetsReq(1, 10));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void getTradePairs() throws Exception {
    GetTradePairsResp resp = ApiClient.getInstance()
            .getTradePairs(new GetTradePairsReq("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "counter", 1, 10));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void preOrder() throws Exception {
    PreOrderResp resp = ApiClient.getInstance()
            .preOrder(new PreOrderReq("test_a01" + System.currentTimeMillis(), "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "0.001", "https://a.com", 1L));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void orderInfo() throws Exception {
    OrderInfoResp resp = ApiClient.getInstance()
            .orderInfo(new OrderInfoReq("tc201812255320000000000002"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void payOrder() throws Exception {
    PayOrderResp resp = ApiClient.getInstance()
            .payOrder(new PayOrderReq("tc201812255320000000000002", "test", "test", "xx", "xx", "xx", "xx", "0.01"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void queryOrder() throws Exception {
    QueryOrderResp resp = ApiClient.getInstance()
            .queryOrder(QueryOrderReq.getInstanceByOutTradeNo("xxx"));
    System.err.println(JSON.toJSONString(resp));
  }

  @Test
  public void revokeOrder() throws Exception {
    RevokeOrderResp resp = ApiClient.getInstance()
            .revokeOrder(RevokeOrderReq.getInstanceByTradingchainNo("tc201812255320000000000002"));
    System.err.println(JSON.toJSONString(resp));
  }
}