package top.whf.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.common.query.Query;

/**
 * @ClassName SysMenuQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/2 10:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysMenuQuery extends Query {
    @Schema(description = "菜单类型")
    private Integer type;
}
