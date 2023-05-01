package top.whf.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.common.query.Query;
/**
 * @ClassName NoticeQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query{
    @Schema(description = "通知标题")
    private String title;
    @Schema(description = "内容")
    private String content;
    @Schema(description = "创建起始时间")
    private String beginTime;
    @Schema(description = "创建结束时间")
    private String endTime;
}
