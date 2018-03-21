package ex.aaronfae.spring.highlightjpa.service;

import ex.aaronfae.spring.highlightjpa.dao.PersonRepository;
import ex.aaronfae.spring.highlightjpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if ("汪云飞".equals(person.getName())) {
            throw new IllegalArgumentException("汪云飞已存在，数据将回滚");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if ("汪云飞".equals(person.getName())) {
            throw new IllegalArgumentException("汪云飞已存在，数据将不回滚");
        }
        return p;
    }
}
