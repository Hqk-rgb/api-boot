package top.whf.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.mybatis.entity.BaseEntity;
/**
 * @ClassName SysRoleEntity
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:09
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}
