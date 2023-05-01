package top.whf.dao;

import org.apache.ibatis.annotations.Mapper;
import top.whf.entity.NoticeEntity;
import top.whf.mybatis.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName NoticeDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:11
 */
@Mapper
public interface NoticeDao extends BaseDao<NoticeEntity>{
    List<NoticeEntity> getList(Map<String,Object> params);
}
