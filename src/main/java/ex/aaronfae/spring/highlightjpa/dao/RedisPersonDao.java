package ex.aaronfae.spring.highlightjpa.dao;

import ex.aaronfae.spring.highlightjpa.entity.RedisPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RedisPersonDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOps;

    public void stringRedisTemplateDemo() {
        valOpsStr.set("xx", "yy");
    }

    public void save(RedisPerson redisPerson) {
        valOps.set(redisPerson.getId(), redisPerson);
    }

    public String getString() {
        return valOpsStr.get("xx");
    }

    public RedisPerson getRedisPerson() {
        return (RedisPerson) valOps.get("1");
    }
}
