package top.whf.security.mobile;

/**
 * @ClassName MobileVerifyCodeService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:31
 */
public interface MobileVerifyCodeService {
    boolean verifyCode(String mobile, String code);
}
