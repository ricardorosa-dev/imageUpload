package dev.ricardorosa.ImageUpload.Controller;

import dev.ricardorosa.ImageUpload.DTO.ImageDTO;
import dev.ricardorosa.ImageUpload.Model.Image;
import dev.ricardorosa.ImageUpload.Service.ImageService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping("/list")
    public List<ImageDTO> findAll() {
        return service.findAll().stream()
                .map(this::toImageDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{imageId}")
    public ImageDTO getImage(@PathVariable String imageId) {
        return this.toImageDTO(service.getImage(imageId));
    }

    @GetMapping("/list/{personId}")
    public List<ImageDTO> getImageIdList(
            @PathVariable("personId") String personId) {
        return service.getByPersonId(personId).stream()
                .map(this::toImageDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/image")
    public String save(
            @RequestParam("file") MultipartFile file,
            @RequestParam String email,
            @RequestParam String personId) throws IOException {
        Image imageToSave = Image.builder()
                .email(email)
                .personId(personId)
                .image(new Binary(BsonBinarySubType.BINARY, file.getBytes()))
                .name(file.getName()).build();

        return service.save(imageToSave).toHexString();
    }

    ImageDTO toImageDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId().toHexString())
                .title(image.getName())
                .personId(image.getPersonId())
                .image(Base64.getEncoder().encodeToString(image.getImage().getData())).build();
    }
}
