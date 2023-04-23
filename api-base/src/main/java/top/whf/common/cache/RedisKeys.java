package top.whf.common.cache;

/**
 * @ClassName RedisKeys
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 17:09
 */
public class RedisKeys {
    /**
     * 验证码 Key
     */
    public static String getCaptchaKey(String key) {
        return "sys:captcha:" + key;
    }

    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }
}
