package org.example.demo.service;

import org.example.demo.entity.Person;
import org.example.demo.exception.ResourceNotFoundException;
import org.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setFirstName(personDetails.getFirstName());
                    person.setLastName(personDetails.getLastName());
                    person.setAddress(personDetails.getAddress());
                    return personRepository.save(person);
                }).orElseThrow(() -> new ResourceNotFoundException("Person with ID " + id + " not found"));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
