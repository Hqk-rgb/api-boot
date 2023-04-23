package top.whf.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.whf.mybatis.dao.BaseDao;
import top.whf.rbac.entity.SysMenuEntity;

import java.util.List;
/**
 * @ClassName SysMenuDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:21
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity>{
}
