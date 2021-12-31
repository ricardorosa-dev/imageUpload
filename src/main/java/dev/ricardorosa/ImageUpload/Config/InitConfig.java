package dev.ricardorosa.ImageUpload.Config;

import dev.ricardorosa.ImageUpload.Model.Person;
import dev.ricardorosa.ImageUpload.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Person john = Person.builder()
                .name("John")
                .build();
        personRepository.save(john);

    }
}
