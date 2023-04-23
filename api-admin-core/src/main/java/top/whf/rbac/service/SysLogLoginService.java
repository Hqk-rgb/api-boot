package top.whf.rbac.service;

import top.whf.common.utils.PageResult;
import top.whf.mybatis.service.BaseService;
import top.whf.rbac.entity.SysLogLoginEntity;
import top.whf.rbac.query.SysLogLoginQuery;
import top.whf.rbac.vo.SysLogLoginVO;
/**
 * @ClassName SysLogLoginService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:42
 */
public interface SysLogLoginService extends BaseService<SysLogLoginEntity>{
    /**
     * 按条件分页查询
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     *
     * @param username  用户名
     * @param status    登录状态
     * @param operation 操作信息
     */
    void save(String username, Integer status, Integer operation);
}
