package dev.ricardorosa.ImageUpload.Repository;

import dev.ricardorosa.ImageUpload.Model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {
}
