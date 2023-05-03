package top.whf.storage.properties;

import lombok.Data;

/**
 * @ClassName MinioStorageProperties
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 14:34
 */
@Data
public class MinioStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
