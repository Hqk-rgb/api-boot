package top.whf.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
/**
 * @ClassName UserGenderEnum
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:04
 */
@Getter
@AllArgsConstructor
public enum UserGenderEnum {
    /**
     * 男
     */
    MAN(0, "男"),
    /**
     * 女
     */
    WOMEN(1, "女"),
    /**
     * 未知
     */
    UNKNOWN(2,"未知");

    private final int value;
    private final String name;

    public static String getNameByValue(int value) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }

}
