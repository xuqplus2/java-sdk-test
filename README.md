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
