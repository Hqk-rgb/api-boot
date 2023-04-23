package top.whf.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.mybatis.entity.BaseEntity;
/**
 * @ClassName SysRoleMenuEntity
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends BaseEntity{
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
}
