package boilerplate.code.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import boilerplate.code.Constant;
import jakarta.annotation.PostConstruct;

@Repository
public class ValueRepository {
    @Autowired
    @Qualifier(Constant.REDIS_TEMPLATE)
    private RedisTemplate<String, String> template;

    private ValueOperations<String, String> ops;

    @PostConstruct
    public void init() {
        ops = template.opsForValue();
    }

    public void create(String key, String value) {
        ops.set(key, value);
    }

    public String getValue(String key) {
        return ops.get(key);
    }

    public boolean delete(String key) {
        return template.delete(key);
    }

    public void incrementValue(String key) {
        ops.increment(key);
    }

    public void decrementValue(String key) {
        ops.decrement(key);
    }

    public void incrementBy(String key, int num) {
        ops.increment(key, num);
    }

    public void decrementBy(String key, int num) {
        ops.decrement(key, num);
    }

    public boolean isExisting(String key) {
        return template.hasKey(key);
    }
}
