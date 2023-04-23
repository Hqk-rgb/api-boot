package top.whf.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.whf.common.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName NoticeVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:10
 */
@Data
@Schema(description = "通知")
public class NoticeVO implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "通知标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "通知标题不能为空")
    private String title;

    @Schema(description = "通知内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "通知内容不能为空")
    private String content;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;
}
