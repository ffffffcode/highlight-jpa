package ex.aaronfae.spring.highlightjpa.dao;

import ex.aaronfae.spring.highlightjpa.entity.MongoPerson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoPersonRepository extends MongoRepository<MongoPerson, String> {

    @Query("{'age': ?0}")
    List<MongoPerson> withQueryFindByAge(Integer age);

    MongoPerson findByName(String name);
}
