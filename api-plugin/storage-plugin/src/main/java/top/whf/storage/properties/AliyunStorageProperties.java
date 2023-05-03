package top.whf.storage.properties;

import lombok.Data;

/**
 * @ClassName AliyunStorageProperties
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 14:34
 */
@Data
public class AliyunStorageProperties {
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
