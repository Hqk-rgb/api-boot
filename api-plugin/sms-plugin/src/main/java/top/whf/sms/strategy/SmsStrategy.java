package top.whf.sms.strategy;

import java.util.Map;

/**
 * @ClassName SmsStrategy
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:15
 */
public interface SmsStrategy {
    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 参数
     */
    void send(String mobile, Map<String, String> params);
}
