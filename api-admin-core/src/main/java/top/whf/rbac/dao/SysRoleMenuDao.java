package top.whf.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.whf.mybatis.dao.BaseDao;
import top.whf.rbac.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * @ClassName SysRoleMenuDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:22
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> getMenuIdList(@Param("roleId") Long roleId);
}
