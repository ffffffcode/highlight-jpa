package ex.aaronfae.spring.highlightjpa.controller;

import ex.aaronfae.spring.highlightjpa.dao.MongoPersonRepository;
import ex.aaronfae.spring.highlightjpa.entity.MongoLocation;
import ex.aaronfae.spring.highlightjpa.entity.MongoPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
public class MongoPersonController {

    @Autowired
    private MongoPersonRepository mongoPersonRepository;

    @RequestMapping("/save")
    public MongoPerson save() {
        MongoPerson mongoPerson = new MongoPerson("af", 21);
        Collection<MongoLocation> locations = new LinkedHashSet<>();
        MongoLocation location1 = new MongoLocation("清远", "1997");
        MongoLocation location2 = new MongoLocation("广州", "2012");
        MongoLocation location3 = new MongoLocation("厦门", "2013");
        MongoLocation location4 = new MongoLocation("香港", "2014");
        MongoLocation location5 = new MongoLocation("澳门", "2016");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        locations.add(location5);
        mongoPerson.setLocations(locations);
        return mongoPersonRepository.save(mongoPerson);
    }

    @RequestMapping("/query1")
    public MongoPerson query1(String name) {
        return mongoPersonRepository.findByName(name);
    }

    @RequestMapping("/query2")
    public List<MongoPerson> query2(Integer age) {
        return mongoPersonRepository.withQueryFindByAge(age);
    }
}
