package ex.aaronfae.spring.highlightjpa.controller;

import ex.aaronfae.spring.highlightjpa.entity.Person;
import ex.aaronfae.spring.highlightjpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/rollback")
    public Person rollback(Person person) {
        return personService.savePersonWithRollBack(person);
    }

    @RequestMapping("/noRollback")
    public Person noRollback(Person person) {
        return personService.savePersonWithoutRollBack(person);
    }
}
