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
}
