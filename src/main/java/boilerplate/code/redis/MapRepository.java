package boilerplate.code.redis;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MapRepository {
    @Autowired
    private RedisTemplate<String, String> template;

    private HashOperations<String, String, String> ops;

    @PostConstruct
    public void init() {
        ops = template.opsForHash();
    }

    public void add(String key, String hashKey, String value) {
        ops.put(key, hashKey, value);
    }

    public String get(String key, String hashKey) {
        return ops.get(key, hashKey);
    }

    public long delete(String key, String hashKey) {
        return ops.delete(key, hashKey);
    }

    public boolean hasKey(String key, String hashKey) {
        return ops.hasKey(key, hashKey);
    }

    public Map<String, String> entries(String key) {
        return ops.entries(key);
    }

    public Set<String> getKeys(String key) {
        return ops.keys(key);
    }
    
    public List<String> getValues(String key) {
        return ops.values(key);
    }

    public long size(String key) {
        return ops.size(key);
    }

    /**
     * Sets a Redis Key to expire after the specified duration of seconds.
     * @param key redis key
     * @param expireDuration in seconds
     */
    public void expire(String key, long expireDuration) {
        Duration timeout = Duration.ofSeconds(expireDuration);
        template.expire(key, timeout);
    }
}
