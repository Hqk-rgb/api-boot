package top.whf.storage.properties;

import lombok.Data;

/**
 * @ClassName LocalStorageProperties
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 14:34
 */
@Data
public class LocalStorageProperties {
    /**
     * 本地存储路径
     */
    private String path;
    /**
     * 资源起始路径
     */
    private String url = "upload";
}
