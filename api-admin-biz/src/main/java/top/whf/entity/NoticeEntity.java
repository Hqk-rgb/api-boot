package top.whf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.whf.mybatis.entity.BaseEntity;
/**
 * @ClassName NoticeEntity
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_notice")
public class NoticeEntity extends BaseEntity{
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
}
