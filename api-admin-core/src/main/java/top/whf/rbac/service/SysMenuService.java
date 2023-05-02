package top.whf.rbac.service;


import top.whf.common.utils.PageResult;
import top.whf.mybatis.service.BaseService;
import top.whf.rbac.entity.SysMenuEntity;
import top.whf.rbac.query.SysMenuQuery;
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
     * 菜单分页
     *
     * @param query 查询参数
     */
    PageResult<SysMenuVO> page(SysMenuQuery query);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取子菜单的数量
     * @param pid  父菜单ID
     */
    Long getSubMenuCount(Long pid);
    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(Long id);
}
