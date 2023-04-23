package top.whf.rbac.service;
import org.springframework.security.core.userdetails.UserDetails;
import top.whf.rbac.entity.SysUserEntity;
/**
 * @ClassName SysUserDetailService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:43
 */
public interface SysUserDetailsService {
    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
