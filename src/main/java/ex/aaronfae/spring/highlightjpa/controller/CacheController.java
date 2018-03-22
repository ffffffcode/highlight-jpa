package ex.aaronfae.spring.highlightjpa.controller;

import ex.aaronfae.spring.highlightjpa.entity.Person;
import ex.aaronfae.spring.highlightjpa.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/put")
    public Person put(Person person) {
        return cacheService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return cacheService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        cacheService.remove(id);
        return "remove ok";
    }
}
