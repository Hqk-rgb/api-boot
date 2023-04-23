package top.whf.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.mybatis.entity.BaseEntity;
/**
 * @ClassName SysUserRoleEntity
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户ID
     */
    private Long userId;
}
