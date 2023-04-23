package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.whf.mybatis.service.impl.BaseServiceImpl;
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
}
