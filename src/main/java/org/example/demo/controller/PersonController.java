package org.example.demo.controller;

import org.example.demo.dto.PersonDTO;
import org.example.demo.entity.Person;
import org.example.demo.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;
    private final ModelMapper modelMapper;

    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons().stream()
                .map(person -> modelMapper.map(person, PersonDTO.class))
                .toList();
    }

    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return modelMapper.map(person, PersonDTO.class);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        return modelMapper.map(personService.createPerson(person), PersonDTO.class);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        return modelMapper.map(personService.updatePerson(id, person), PersonDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
