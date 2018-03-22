package ex.aaronfae.spring.highlightjpa.dao;

import ex.aaronfae.spring.highlightjpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CacheRepository extends JpaRepository<Person, Long> {
}
