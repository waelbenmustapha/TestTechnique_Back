package com.example.TestTechnique_Back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestTechnique_Back.entity.Person;
import com.example.TestTechnique_Back.repository.PersonReopistory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/person")
public class PersonController {

  private final PersonReopistory personReopistory;

  @Autowired
  public PersonController(PersonReopistory personReopistory) {
    this.personReopistory = personReopistory;
  }

  @GetMapping("/allpersons")
  public ResponseEntity getAllPersons() {

    return new ResponseEntity<>(personReopistory.findAll(), HttpStatus.OK);
  }

  @PostMapping("/addperson")
  public ResponseEntity AddPerson(@RequestBody Person person) {
    try {
      personReopistory.save(person);

      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed To Add person because : " + e);
    }
  }

}
