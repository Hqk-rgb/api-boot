package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.whf.security.mobile.MobileVerifyCodeService;
import top.whf.sms.api.SmsApi;

/**
 * @ClassName MobileVerifyCodeServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 12:45
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
   private final SmsApi smsApi;
    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsApi.verifyCode(mobile,code);
    }
}
