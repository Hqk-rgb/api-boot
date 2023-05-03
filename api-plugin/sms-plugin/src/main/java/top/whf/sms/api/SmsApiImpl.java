package top.whf.sms.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.whf.sms.cache.SmsSendCache;
import top.whf.sms.service.SmsService;

import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName SmsApiImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:20
 */
@Component
@AllArgsConstructor
public class SmsApiImpl implements SmsApi{
    private final SmsService smsService;
    private final SmsSendCache smsSendCache;

    @Override
    public boolean sendCode(String mobile, String key, String value) {
        // 短信参数
        Map<String, String> params = new HashMap<>();
        params.put(key, value);
        // 发送短信
        boolean flag = smsService.send(mobile, params);
        if (flag) {
            smsSendCache.saveCode(mobile, value);
        }
        return flag;
    }

    @Override
    public boolean verifyCode(String mobile, String code) {
        String value = smsSendCache.getCode(mobile);
        if (value != null) {
            // 删除短信验证码
            smsSendCache.deleteCode(mobile);
            // 校验
            return value.equalsIgnoreCase(code);
        }
        return false;
    }
}
