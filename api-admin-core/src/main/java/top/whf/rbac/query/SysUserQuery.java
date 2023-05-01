package top.whf.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.common.query.Query;

import java.util.Date;

/**
 * @ClassName SysUserQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/28 14:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户查询参数")
public class SysUserQuery extends Query {
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "姓名")
    private String realName;
    @Schema(description = "手机号码")
    private String mobile;
    @Schema(description = "性别")
    private String gender;
    @Schema(description = "创建起始时间")
    private Date beginTime;
    @Schema(description = "创建结束时间")
    private Date endTime;

}
