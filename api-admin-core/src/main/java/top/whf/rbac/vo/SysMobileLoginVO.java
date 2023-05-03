package top.whf.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @ClassName SysMobileLoginVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 10:38
 */
@Data
@Schema(description = "手机号登录vo")
public class SysMobileLoginVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "验证码")
    private String code;
}
