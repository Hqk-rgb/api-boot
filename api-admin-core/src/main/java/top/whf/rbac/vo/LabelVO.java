package top.whf.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @ClassName LabelVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/25 13:44
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "分类统计标签")
public class LabelVO implements Serializable {
    @Serial
    private  static final long serialVersionUID = 1L;
    @Schema(description = "标签名",requiredMode = Schema.RequiredMode.REQUIRED)
    private String label;
    @Schema(description = "标签值",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer value;
}
