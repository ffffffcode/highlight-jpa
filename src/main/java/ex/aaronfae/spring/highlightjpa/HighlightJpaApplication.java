package ex.aaronfae.spring.highlightjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableCaching
@EnableMongoRepositories
public class HighlightJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighlightJpaApplication.class, args);
    }
}
