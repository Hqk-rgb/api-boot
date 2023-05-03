package top.whf.storage;

import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.whf.storage.service.StorageService;

import java.io.File;
import java.nio.file.Files;

/**
 * @ClassName FileUploadTest
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/3 15:18
 */
@SpringBootTest
@Slf4j
public class FileUploadTest {
    @Autowired
    private StorageService storage;

    @Test
    public void uploadTest() throws Exception {
        File file = new File("C:\\Users\\26570\\Desktop\\img\\me.jpg");
        byte[] data = IoUtil.readBytes(Files.newInputStream(file.toPath()));
        String path = storage.getPath(file.getName());
        String url = storage.upload(data,path);
        log.info(url);
    }
}
