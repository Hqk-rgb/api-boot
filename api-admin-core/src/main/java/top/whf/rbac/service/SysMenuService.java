package top.whf.rbac.service;


import top.whf.mybatis.service.BaseService;
import top.whf.rbac.entity.SysMenuEntity;
import top.whf.rbac.vo.SysMenuVO;
import top.whf.security.user.UserDetail;

import java.util.List;
import java.util.Set;
/**
 * @ClassName SysMenuService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:39
 */
public interface SysMenuService extends BaseService<SysMenuEntity>{
    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
}
