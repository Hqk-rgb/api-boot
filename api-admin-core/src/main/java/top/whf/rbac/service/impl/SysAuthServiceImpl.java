package top.whf.rbac.service.impl;

import cn.hutool.core.util.RandomUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.whf.common.exception.ServerException;
import top.whf.rbac.service.SysAuthService;
import top.whf.rbac.service.SysCaptchaService;
import top.whf.rbac.service.SysUserService;
import top.whf.rbac.vo.SysAccountLoginVO;
import top.whf.rbac.vo.SysMobileLoginVO;
import top.whf.rbac.vo.SysTokenVO;
import top.whf.rbac.vo.SysUserVO;
import top.whf.security.cache.TokenStoreCache;
import top.whf.security.mobile.MobileAuthenticationToken;
import top.whf.security.user.UserDetail;
import top.whf.security.utils.TokenUtils;
import top.whf.sms.api.SmsApi;

/**
 * @ClassName SysAuthServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:35
 */
@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService{
    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;
    private final SysCaptchaService sysCaptchaService;
    private final SysUserService sysUserService;
    private final SmsApi smsApi;

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {
        //如果不需要验证码，可以在这里丢掉
//        boolean flag = sysCaptchaService.validate(login.getKey(), login.getCaptcha());
//        if (!flag) {
//            throw  new ServerException("验证码不正确");
//        }

        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存，accessToken默认过期时间为24小时
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // 获取用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        // 从缓存中删除用户
        tokenStoreCache.deleteUser(accessToken);
    }

    @Override
    public SysTokenVO loginByMobile(SysMobileLoginVO login) {
        Authentication authentication;
        try {
            //用户认证
            authentication = authenticationManager.authenticate(
                    new MobileAuthenticationToken(login.getMobile(), login.getCode()));
        } catch (BadCredentialsException e) {
            throw new ServerException("手机号或验证码错误");
        }
        //用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();
        //生成 accessToken
        String accessToken = TokenUtils.generator();
        //保存用户信息到缓存，accessToken默认过期时间为24小时
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public boolean sendCode(String mobile) {
        //生成6位验证码
        String code = RandomUtil.randomNumbers(6);
        SysUserVO user = sysUserService.getByMobile(mobile);
        if (user == null) {
            throw new ServerException("手机号码未注册");
        }
        //发送短信验证码
        return smsApi.sendCode(mobile,"code",code);
    }
}
