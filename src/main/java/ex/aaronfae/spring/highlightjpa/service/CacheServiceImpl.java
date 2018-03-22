package ex.aaronfae.spring.highlightjpa.service;

import ex.aaronfae.spring.highlightjpa.dao.CacheRepository;
import ex.aaronfae.spring.highlightjpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheRepository cacheRepository;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = cacheRepository.save(person);
        System.out.println("为id、key为：" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id、key为：" + id + "的数据缓存");
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = cacheRepository.getOne(person.getId());
        System.out.println("为id、key为：" + p.getId() + "数据做了缓存");
        return p;
    }
}
