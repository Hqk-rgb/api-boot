package top.whf.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName SysRoleUserQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/2 09:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "分配角色查询")
public class SysRoleUserQuery extends SysUserQuery{
    @Schema(description = "角色ID")
    private Long roleId;
}
