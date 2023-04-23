package top.whf.rbac.service;

import top.whf.rbac.vo.SysAccountLoginVO;
import top.whf.rbac.vo.SysTokenVO;
/**
 * @ClassName SysAuthService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:35
 */
public interface SysAuthService {
    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}
