package boilerplate.code.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import boilerplate.code.Constant;
import jakarta.annotation.PostConstruct;

@Repository
public class ListRepository {
    @Autowired
    @Qualifier(Constant.REDIS_TEMPLATE)
    private RedisTemplate<String, String> template;
    
    private ListOperations<String, String> ops;

    @PostConstruct
    public void init() {
        ops = template.opsForList();
    }

    public void leftPush(String key, String value) {
        ops.leftPush(key, value);
    }

    public void rightPush(String key, String value) {
        ops.rightPush(key, value);
    }

    public String leftPop(String key) {
        return ops.leftPop(key);
    }

    public String rightPop(String key) {
        return ops.rightPop(key);
    }

    public String get(String key, long index) {
        return ops.index(key, index);
    }

    public long size(String key) {
        return ops.size(key);
    }

    public List<String> getList(String key) {
        return ops.range(key, 0, -1);
    }

    public void delete(String key, String value) {
        ops.remove(key, 1, value);
    }
}
