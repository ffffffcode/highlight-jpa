package ex.aaronfae.spring.highlightjpa.service;

import ex.aaronfae.spring.highlightjpa.entity.Person;

public interface CacheService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
