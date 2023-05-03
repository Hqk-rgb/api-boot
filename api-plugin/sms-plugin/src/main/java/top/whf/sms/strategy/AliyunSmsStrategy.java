package top.whf.sms.strategy;

import cn.hutool.core.map.MapUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import top.whf.common.constant.Constant;
import top.whf.common.exception.ServerException;
import top.whf.common.utils.JsonUtils;
import top.whf.sms.config.SmsConfig;

import java.util.Map;

/**
 * @ClassName AliyunSmsStrategy
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:15
 */
@Slf4j
public class AliyunSmsStrategy implements SmsStrategy{
    private final Client client;
    private final SmsConfig smsConfig;

    public AliyunSmsStrategy(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
        try {
            Config config = new Config();
            config.setAccessKeyId(smsConfig.getAccessKey());
            config.setAccessKeySecret(smsConfig.getSecretKey());
            config.endpoint = "dysmsapi.aliyuncs.com";
            this.client = new Client(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void send(String mobile, Map<String, String> params) {
        SendSmsRequest request = new SendSmsRequest();
        request.setSignName(smsConfig.getSignName());
        request.setTemplateCode(smsConfig.getTemplateId());
        request.setPhoneNumbers(mobile);
        // request.setTemplateParam("{\"code\":\"1234\"}");
        if (MapUtil.isNotEmpty(params)) {
            request.setTemplateParam(JsonUtils.toJsonString(params));
        }
        try {
            // 发送短信
            SendSmsResponse response = client.sendSms(request);
            // 发送失败
            if (!Constant.OK.equalsIgnoreCase(response.getBody().getCode())) {
                throw new ServerException(response.getBody().getMessage());
            }
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }
}
