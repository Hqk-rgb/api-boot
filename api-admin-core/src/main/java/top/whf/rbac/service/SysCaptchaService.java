package top.whf.rbac.service;
import top.whf.rbac.vo.SysCaptchaVO;
/**
 * @ClassName SysCaptchaService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 20:24
 */
public interface SysCaptchaService {
    /**
     * 生成验证码
     */
    SysCaptchaVO generate();

    /**
     * 验证码效验
     *
     * @param key  key
     * @param code 验证码
     * @return true：成功  false：失败
     */
    boolean validate(String key, String code);
}
