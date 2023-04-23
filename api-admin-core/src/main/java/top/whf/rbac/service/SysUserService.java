package top.whf.rbac.service;

import top.whf.mybatis.service.BaseService;
import top.whf.rbac.entity.SysUserEntity;
/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:36
 */
public interface SysUserService extends BaseService<SysUserEntity>{
    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);
}
