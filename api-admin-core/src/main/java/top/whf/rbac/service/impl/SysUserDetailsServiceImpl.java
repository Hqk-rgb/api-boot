package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.whf.rbac.convert.SysUserConvert;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.enums.UserStatusEnum;
import top.whf.rbac.service.SysUserDetailsService;
import top.whf.security.user.UserDetail;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName SysUserDetailsServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:43
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService{
    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        // 用户权限列表
        Set<String> authoritySet = new HashSet<>();
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }
}
