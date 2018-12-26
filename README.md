# tradingchain-sdk

在项目描述文件里添加gitpack和依赖

#### maven
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Tradingchain</groupId>
        <artifactId>tradingchain-sdk</artifactId>
        <version>0.0.1</version>
    </dependency>
</dependencies>
```

#### gradle
```
allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.Tradingchain:tradingchain-sdk:0.0.1'
}
```

#### 使用方法示例
```$xslt
在spring中使用:

@Configuration
public class Config {

  public static final String BASE_URL = "http://api.1mfpay.com";
  public static final String API_KEY = "tradingchain";
  public static final String PLATFORM = "tradingchain_test";
  public static final String SECRET = "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm";

  @Bean
  public ApiClient apiClient() {
    return ApiClient.build(BASE_URL, API_KEY, PLATFORM, SECRET);
  }
}

@Component
public class ApiServiceSdkTestApplication implements CommandLineRunner {

  @Autowired
  ApiClient apiClient;

  public void run() throws Exception {
    IsUserExistsResp resp = ApiClient.getInstance().isUserExists(new IsUserExistsReq("xxx"));

    System.out.println(resp.code);
    System.out.println(resp.msg);
    System.out.println(resp.data);
    System.out.println(resp.data.exist);
    System.out.println(JSON.toJSONString(resp));
  }
}
```

```$xslt
main方法中使用:

public class Test {

  public static final String BASE_URL = "http://api.1mfpay.com";
  public static final String API_KEY = "tradingchain";
  public static final String PLATFORM = "tradingchain_test";
  public static final String SECRET = "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm";

  static {
    ApiClient.build(BASE_URL, API_KEY, PLATFORM, SECRET);
  }

  public static void main(String[] args) throws Exception {
    ApiClient.build(BASE_URL, API_KEY, PLATFORM, SECRET);

    ApiClient apiClient = ApiClient.getInstance();
    // ...
  }
}

```
