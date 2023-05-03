package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.whf.rbac.dao.SysUserDao;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.service.SysUserDetailsService;
import top.whf.security.mobile.MobileUserDetailsService;

/**
 * @ClassName MobileUserDetailsServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 12:40
 */
@Service
@AllArgsConstructor
public class MobileUserDetailsServiceImpl implements MobileUserDetailsService {
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserDao sysUserDao;
    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        SysUserEntity userEntity = sysUserDao.getByMobile(mobile);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名或手机号码错误");
        }
        return sysUserDetailsService.getUserDetails(userEntity);
    }
}
