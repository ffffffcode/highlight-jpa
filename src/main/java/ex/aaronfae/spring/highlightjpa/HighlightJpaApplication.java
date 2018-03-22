package ex.aaronfae.spring.highlightjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HighlightJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighlightJpaApplication.class, args);
    }
}
