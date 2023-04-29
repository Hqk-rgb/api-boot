package top.whf.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.whf.mybatis.dao.BaseDao;
import top.whf.rbac.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysUserDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:14
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity>{
    default SysUserEntity getByUsername(String username){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }
    default SysUserEntity getByMobile(String mobile){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("mobile", mobile));
    }
    List<SysUserEntity> getList(Map<String,Object> params);
    SysUserEntity getById(@Param("id") Long id);
}
