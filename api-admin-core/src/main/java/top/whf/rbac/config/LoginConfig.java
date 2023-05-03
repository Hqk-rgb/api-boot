package top.whf.rbac.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.whf.sms.api.SmsApi;

/**
 * @ClassName LoginConfig
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:39
 */
@Configuration
public class LoginConfig {
    @Bean
    @ConditionalOnMissingBean
    SmsApi smsApi() {
        return new SmsApi() {
            @Override
            public boolean sendCode(String mobile, String key, String value) {
                return false;
            }

            @Override
            public boolean verifyCode(String mobile, String code) {
                return false;
            }
        };
    }
}
