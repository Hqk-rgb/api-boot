package top.whf.service;

import org.springframework.web.multipart.MultipartFile;
import top.whf.common.utils.PageResult;
import top.whf.entity.NoticeEntity;
import top.whf.mybatis.service.BaseService;
import top.whf.query.NoticeQuery;
import top.whf.vo.NoticeVO;

import java.util.List;
/**
 * @ClassName NoticeService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:13
 */
public interface NoticeService extends BaseService<NoticeEntity>{
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<NoticeVO> page(NoticeQuery query);

    /**
     * 获取所有通知数据
     *
     * @return list
     */
    List<NoticeVO> getList();

    /**
     * 新增通知
     *
     * @param vo vo
     */
    void save(NoticeVO vo);

    /**
     * 修改通知
     *
     * @param vo vo
     */
    void update(NoticeVO vo);

    /**
     * 根据id删除通知(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);
}
