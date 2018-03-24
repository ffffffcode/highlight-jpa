package ex.aaronfae.spring.highlightjpa.controller;

import ex.aaronfae.spring.highlightjpa.dao.RedisPersonDao;
import ex.aaronfae.spring.highlightjpa.entity.RedisPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private RedisPersonDao redisPersonDao;

    @RequestMapping("/redisSave")
    public void redisSave() {
        RedisPerson redisPerson = new RedisPerson("1", "af", 21);
        redisPersonDao.save(redisPerson);
        redisPersonDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr() {
        return redisPersonDao.getString();
    }

    @RequestMapping("/getPerson")
    public RedisPerson getPerson() {
        return redisPersonDao.getRedisPerson();
    }
}
