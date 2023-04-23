package top.whf.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.common.query.Query;
/**
 * @ClassName SysLogLoginQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 20:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "登录日志查询参数")
public class SysLogLoginQuery extends Query{
    @Schema(description = "用户名")
    private String username;


    @Schema(description = "登录地点")
    private String address;


    @Schema(description = "登录状态 0：失败  1：成功")
    private Integer status;
}
