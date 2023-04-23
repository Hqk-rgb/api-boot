package top.whf.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @ClassName MenuTypeEnum
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:07
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {
    /**
     * 菜单
     */
    MENU(0),
    /**
     * 按钮
     */
    BUTTON(1),
    /**
     * 接口
     */
    INTERFACE(2);

    private final int value;
}
