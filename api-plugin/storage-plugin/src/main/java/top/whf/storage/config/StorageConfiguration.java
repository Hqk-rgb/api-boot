package top.whf.storage.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.whf.storage.enums.StorageTypeEnum;
import top.whf.storage.properties.StorageProperties;
import top.whf.storage.service.AliyunStorageService;
import top.whf.storage.service.LocalStorageService;
import top.whf.storage.service.MinioStorageService;
import top.whf.storage.service.StorageService;

/**
 * @ClassName StorageConfiguration
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 14:33
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class StorageConfiguration {
    @Bean
    public StorageService storageService(StorageProperties properties) {
        if (properties.getConfig().getType() == StorageTypeEnum.LOCAL) {
            return new LocalStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.ALIYUN) {
            return new AliyunStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.MINIO) {
            return new MinioStorageService(properties);
        }
        return null;
    }
}
