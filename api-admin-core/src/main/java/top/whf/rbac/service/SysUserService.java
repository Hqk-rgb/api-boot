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
    PageResult<SysUserVO> page(SysUserQuery query);
    void save(SysUserVO vo);
    void update(SysUserVO vo);
    void delete(List<Long> ids);
    void importByExcel(MultipartFile file,String password);
    void export();
    void updateStatus(long id,int status);
}
