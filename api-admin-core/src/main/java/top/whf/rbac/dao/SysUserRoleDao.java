package top.whf.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.whf.mybatis.dao.BaseDao;
import top.whf.rbac.entity.SysUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysUserRoleDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:20
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity>{
    /**
     * 角色ID列表
     * @param userId  用户ID
     *
     * @return  返回角色ID列表
     */
    List<Long> getRoleIdList(@Param("userId") Long userId);

}
