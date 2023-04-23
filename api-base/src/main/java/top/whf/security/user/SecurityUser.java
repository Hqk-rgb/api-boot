package top.whf.security;

import org.springframework.security.core.context.SecurityContextHolder;
/**
 * @ClassName SecurityUser
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 18:31
 */
public class SecurityUser {
    /**
     * 获取用户信息
     */
    public static UserDetail getUser() {
        UserDetail user;
        try {
            user = (UserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return new UserDetail();
        }

        return user;
    }

    /**
     * 获取用户ID
     */
    public static Long getUserId() {
        return getUser().getId();
    }
}
