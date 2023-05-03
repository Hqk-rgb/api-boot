package top.whf.sms.context;

import top.whf.common.exception.ServerException;
import top.whf.sms.config.SmsConfig;
import top.whf.sms.enums.SmsPlatformEnum;
import top.whf.sms.strategy.AliyunSmsStrategy;
import top.whf.sms.strategy.SmsStrategy;

import java.util.Map;

/**
 * @ClassName SmsContext
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:18
 */
public class SmsContext {
    private final SmsStrategy smsStrategy;

    public SmsContext(SmsConfig config) {
        if (config.getPlatform() == SmsPlatformEnum.ALIYUN.getValue()) {
            this.smsStrategy = new AliyunSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.TENCENT.getValue()) {
            // TODO 腾讯云短信发送
            this.smsStrategy = null;
        } else {
            throw new ServerException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsStrategy.send(mobile, params);
    }
}
