package top.whf.rbac.service;

import org.springframework.web.multipart.MultipartFile;
import top.whf.common.utils.PageResult;
import top.whf.mybatis.service.BaseService;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.query.SysUserQuery;
import top.whf.rbac.vo.SysUserVO;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:36
 */
public interface SysUserService extends BaseService<SysUserEntity>{
    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 分页查询用户
     * @param query
     * @return
     */
    PageResult<SysUserVO> page(SysUserQuery query);

    /**
     * 新增用户
     * @param vo
     */
    void save(SysUserVO vo);

    /**
     * 修改用户
     * @param vo
     */
    void update(SysUserVO vo);

    /**
     * 批量删除用户
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 导出用户信息到表格
     * @param file
     * @param password
     */
    void importByExcel(MultipartFile file,String password);

    /**
     * 导出用户信息到表格
     */
    void export();

    /**
     * 修改用户状态
     * @param id
     * @param status
     */
    void updateStatus(long id,int status);

    /**
     * 根据手机号获取用户
     * @param mobile
     * @return
     */
    SysUserVO getByMobile(String mobile);
}
