package dev.ricardorosa.ImageUpload.Service;

import dev.ricardorosa.ImageUpload.Model.Person;
import dev.ricardorosa.ImageUpload.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }
}
