package top.whf.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.whf.mybatis.dao.BaseDao;
import top.whf.rbac.entity.SysUserEntity;
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
}
