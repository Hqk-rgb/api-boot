package top.whf.rbac.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import top.whf.common.excel.DateConverter;
import top.whf.rbac.convert.GenderTypeConverter;
import top.whf.rbac.convert.StatusTypeConverter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysUserExcelVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/28 14:00
 */
@Data
public class SysUserExcelVO implements Serializable {
    @Serial
    private final  static long serialVersionUID = 1L;
    @ExcelIgnore
    private Long id;
    @ExcelProperty("用户名")
    private String username;
    @ExcelProperty("真实姓名")
    private String realName;
    @ExcelProperty(value = "性别",converter = GenderTypeConverter.class)
    private Integer gender;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("手机号")
    private String mobile;
    @ExcelProperty(value = "状态",converter = StatusTypeConverter.class)
    private Integer status;
    @ExcelProperty(value = "创建时间",converter = DateConverter.class)
    private Date createTime;

}
