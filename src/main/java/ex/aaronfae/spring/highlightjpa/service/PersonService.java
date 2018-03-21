package ex.aaronfae.spring.highlightjpa.service;

import ex.aaronfae.spring.highlightjpa.entity.Person;

public interface PersonService {

    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);
}
