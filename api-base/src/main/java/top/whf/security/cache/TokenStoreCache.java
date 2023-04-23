package top.whf.security.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.whf.common.cache.RedisCache;
import top.whf.common.cache.RedisKeys;
import top.whf.security.user.UserDetail;
/**
 * @ClassName TokenStoreCache
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 18:33
 */
@Component
@AllArgsConstructor
public class TokenStoreCache {
    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
