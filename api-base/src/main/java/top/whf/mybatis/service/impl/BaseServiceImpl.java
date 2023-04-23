package top.whf.mybatis.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.whf.common.query.Query;
import top.whf.mybatis.service.BaseService;
/**
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 18:55
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    /**
     * 获取分页对象
     *
     * @param query 分页参数
     */
    protected IPage<T> getPage(Query query) {
        Page<T> page = new Page<>(query.getPage(), query.getLimit());

        // 排序
        if (StringUtils.isNotBlank(query.getOrder())) {
            if (query.isAsc()) {
                return page.addOrder(OrderItem.asc(query.getOrder()));
            } else {
                return page.addOrder(OrderItem.desc(query.getOrder()));
            }
        }

        return page;
    }
}
