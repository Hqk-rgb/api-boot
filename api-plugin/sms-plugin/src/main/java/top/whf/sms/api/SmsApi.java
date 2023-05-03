package top.whf.sms.api;

/**
 * @ClassName SmsApi
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:20
 */
public interface SmsApi {
    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param key    redis key
     * @param value  redis value
     * @return 发送结果
     */
    boolean sendCode(String mobile, String key, String value);

    /**
     * 验证
     *
     * @param mobile 手机号
     * @param code   验证码
     * @return 验证结果
     */
    boolean verifyCode(String mobile, String code);
}
