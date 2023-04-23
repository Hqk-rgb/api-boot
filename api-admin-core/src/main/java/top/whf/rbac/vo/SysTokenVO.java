package top.whf.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
/**
 * @ClassName SysTokenVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:29
 */
@Data
@AllArgsConstructor
@Schema(description = "用户登录token")
public class SysTokenVO implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "accessToken")
    private String accessToken;
}
