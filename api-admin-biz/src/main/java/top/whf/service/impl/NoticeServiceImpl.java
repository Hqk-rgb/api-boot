package top.whf.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.whf.common.constant.Constant;
import top.whf.common.utils.PageResult;
import top.whf.convert.NoticeConvert;
import top.whf.dao.NoticeDao;
import top.whf.entity.NoticeEntity;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import top.whf.query.NoticeQuery;
import top.whf.service.NoticeService;
import top.whf.vo.NoticeVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:14
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService{
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        Map<String,Object> params = getParams(query);
        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        params.put(Constant.PAGE,page);
        List<NoticeEntity> list = baseMapper.getList(params);
        //return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(list),page.getTotal());
    }
    private Map<String,Object> getParams(NoticeQuery query){
        System.out.println(query);
        Map<String,Object> params = new HashMap<>();
        params.put("title",query.getTitle());
        params.put("content",query.getContent());
        params.put("beginTime",query.getBeginTime());
        params.put("endTime",query.getEndTime());
        return params;
    }

    @Override
    public List<NoticeVO> getList() {
        NoticeQuery query = new NoticeQuery();
        List<NoticeEntity> entityList = baseMapper.selectList(getWrapper(query));
        return NoticeConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(NoticeVO vo) {
        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NoticeVO vo) {
        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    /**
     * 查询条件构造
     *
     * @param query 查询参数
     * @return 查询条件
     */

    private Wrapper<NoticeEntity> getWrapper(NoticeQuery query) {
        LambdaQueryWrapper<NoticeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()), NoticeEntity::getTitle, query.getTitle());
        return wrapper;
    }
}
