package dev.ricardorosa.ImageUpload.Repository;

import dev.ricardorosa.ImageUpload.Model.Image;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends MongoRepository<Image, ObjectId> {

    List<Image> getByPersonId(String personId);
}
