package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.whf.rbac.dao.SysUserDao;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.service.SysUserService;
/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:37
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService{
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }
}
