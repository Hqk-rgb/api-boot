package top.whf.rbac.service;

import top.whf.mybatis.service.BaseService;
import top.whf.rbac.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * @ClassName SysRoleMenuService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:41
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenuEntity>{
    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> getMenuIdList(Long roleId);

    /**
     * 保存或修改
     *
     * @param roleId     角色ID
     * @param menuIdList 菜单ID列表
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 根据角色id列表，删除角色菜单关系
     *
     * @param roleIdList 角色id列表
     */
    void deleteByRoleIdList(List<Long> roleIdList);

    /**
     * 根据菜单id，删除角色菜单关系
     *
     * @param menuId 菜单id
     */
    void deleteByMenuId(Long menuId);
}
