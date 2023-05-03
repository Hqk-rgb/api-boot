package top.whf.sms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName 短信平台枚举
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:13
 */
@Getter
@AllArgsConstructor
public enum SmsPlatformEnum {
    /**
     * 阿里云
     */
    ALIYUN(0),
    /**
     * 腾讯云
     */
    TENCENT(1);

    private final int value;
}
