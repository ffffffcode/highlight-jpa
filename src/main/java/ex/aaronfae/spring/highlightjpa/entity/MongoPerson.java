package ex.aaronfae.spring.highlightjpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

@Document
public class MongoPerson {

    @Id
    private String id;
    private String name;
    private Integer age;
    @Field("location")
    private Collection<MongoLocation> locations = new LinkedHashSet<>();

    public MongoPerson(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Collection<MongoLocation> getLocations() {
        return locations;
    }

    public void setLocations(Collection<MongoLocation> locations) {
        this.locations = locations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
