# DAuth-SDK
DAuth(도담도담 OAuth)를 편리하게 이용할 수 있도록 돕는 JAVA SDK입니다.

DAuth 공식문서 : https://dauth.b1nd.com

# Installation

## Gradle
```gradle
// build.gradle
repositories {
    maven { url 'https://jitpack.io' } //추가
}

dependencies {
    implementation 'com.github.Team-B1ND:DAuth-SDK:v2.0.0' //추가
}
```

# Sample (for Spring)

## Bean
```java
@Bean
public DAuth dauth() {
    return DAuthBuilder.create()
        .clientId(CLIENT_ID)
        .clientSecret(CLIENT_SECRET)
        .build();
}
```

## DI
```java
@Component
public class Sample {

    private DAuth dauth;

    public Sample(final DAuth dauth) {
        this.dauth = dauth;
    }

}
```

## Token 발급
```java
final DAuthTokenInfo tokenInfo = dAuth.issueToken(code);
```
```java
public final class DAuthTokenInfo {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private String expiresIn;

    //getters

}
```

## AccessToken 재발급
```java
final DAuthAccessTokenInfo accessTokenInfo = dAuth.reissueAccessToken(refreshToken);
```
```java
public final class DAuthAccessTokenInfo {

    private String accessToken;
    private String tokenType;
    private String expiresIn;

    //getters

}
```

## User 조회
```java
final DAuthUserInfo userInfo = dAuth.getUser(accessToken);
```
```java
public final class DAuthUserInfo {

    private DAuthUser user;

    public DAuthUser getUser() {
        return user;
    }

    //getters

}

public final class DAuthUser {

    private String uniqueId;
    private Integer grade;
    private Integer room;
    private Integer number;
    private String name;
    private String profileImage; //nullable
    private String role;
    private String email;

    //getters

}
```

## Exception
```java
public class DAuthException extends RuntimeException {

    private final int status;

    public DAuthException(final int status) {
        this.status = status;
    }

    //getter

}
```
