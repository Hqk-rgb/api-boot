package top.whf.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
/**
 * @ClassName SysAuthVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:31
 */
@Data
@Schema(description = "认证返回结果")
public class SysAuthVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户信息")
    private SysUserVO sysUserVO;

    @Schema(description = "用户导航菜单")
    private List<SysMenuVO> nav;

    @Schema(description = "用户导授权信息")
    private Set<String> authority;
}
