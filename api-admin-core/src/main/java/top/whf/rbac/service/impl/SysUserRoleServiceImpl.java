package top.whf.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import top.whf.rbac.dao.SysUserRoleDao;
import top.whf.rbac.entity.SysUserRoleEntity;
import top.whf.rbac.service.SysUserRoleService;
/**
 * @ClassName SysUserRoleServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:39
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService{
}
