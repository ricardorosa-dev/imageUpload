package dev.ricardorosa.ImageUpload.Service;

import dev.ricardorosa.ImageUpload.DTO.ImageDTO;
import dev.ricardorosa.ImageUpload.Model.Image;
import dev.ricardorosa.ImageUpload.Repository.ImageRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;


    public List<Image> findAll() {
        return repository.findAll();
    }

    public Image getImage(String imageId) {
        ObjectId imageObjectId = new ObjectId(imageId);
        Image image = repository.findById(imageObjectId)
                .orElseThrow(() -> new RuntimeException("Null Image!"));

        return image;
    }

    public List<Image> getByPersonId(String personId) {
        return repository.getByPersonId(personId);
    }

    public ObjectId save(Image image) throws IOException {
        Image savedImage = repository.save(image);
        return savedImage.getId();
    }

}
