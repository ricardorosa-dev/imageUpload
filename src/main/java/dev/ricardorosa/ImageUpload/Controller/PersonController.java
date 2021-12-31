package dev.ricardorosa.ImageUpload.Controller;

import dev.ricardorosa.ImageUpload.DTO.PersonDTO;
import dev.ricardorosa.ImageUpload.Model.Person;
import dev.ricardorosa.ImageUpload.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/list")
    public List<PersonDTO> findAll() {
        return service.findAll().stream()
                .map(this::toPersonDTO)
                .collect(Collectors.toList());
    }

    private PersonDTO toPersonDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId().toHexString());
        dto.setName(person.getName());

        return dto;
    }
}


