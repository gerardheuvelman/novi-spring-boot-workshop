package nl.ultimateapps.workshop.controller;

import nl.ultimateapps.workshop.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class PersonController {

    private ArrayList<Person> persons;

    public PersonController() {
        persons = new ArrayList<>();

        //prefill
        Person p = new Person();
        p.setName("Gerard");
        p.setDob(LocalDate.of(1974, 2, 28));
        p.setGender('m');
        persons.add(p);
    }

    @GetMapping("/persons")
    public ResponseEntity<Object> getPersons() {
       return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Object> createPerson(@RequestBody Person person) {
        for (Person p : persons) {
            if (p.getName().equals(person.getName())) {
                return new ResponseEntity<>("This person's name was already in our list", HttpStatus.BAD_REQUEST);
            }
        }
        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);


    }

    @PutMapping("/persons/{id}")
    // gebruik object , dan kun je verschillende datatypen retourneren.
    public ResponseEntity<Object> updatePerson(@PathVariable int id, @RequestBody Person person) {
        if (id >= 0 && id < persons.size()) {
            persons.set(id, person);
            // of Responseentity.OK(body.....)
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {

            return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable int id) {
        if (id >= 0 && id < persons.size()) {
            return new ResponseEntity<>(persons.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable int id) {
        if (id >= 0 && id < persons.size()) {
            persons.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.BAD_REQUEST);
        }
    }
}


