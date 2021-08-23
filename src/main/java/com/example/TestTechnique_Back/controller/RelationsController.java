package com.example.TestTechnique_Back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestTechnique_Back.entity.Person;
import com.example.TestTechnique_Back.entity.Relations;
import com.example.TestTechnique_Back.repository.PersonReopistory;
import com.example.TestTechnique_Back.repository.RelationsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/relations")
public class RelationsController {
  private final RelationsRepository relationsRepository;
  private final PersonReopistory personReopistory;
  @Autowired
  public RelationsController(RelationsRepository relationsRepository,PersonReopistory personReopistory)
  {
    this.relationsRepository=relationsRepository;
    this.personReopistory=personReopistory;
  }

  @GetMapping("/all")
  public ResponseEntity getall()
  {
    return new ResponseEntity<>(relationsRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/specefic/{id}")
  public ResponseEntity getall(@PathVariable Long id)
  {
    return new ResponseEntity<>(relationsRepository.findByPersonneId(id), HttpStatus.OK);
  }
  @PostMapping("/add/{personid}/{relation}/{relatedid}")
public ResponseEntity addRelation(@PathVariable("personid") Long personid,@PathVariable("relation") String relation,@PathVariable("relatedid") Long relatedid)
  {
    Person person = personReopistory.findById(personid).get();
    Person relatedperson = personReopistory.findById(relatedid).get();
    Relations newrelation = new Relations(null,person,relatedperson,relation);
   relationsRepository.save(newrelation);
    return new ResponseEntity<>("Added succefuly", HttpStatus.OK);

  }
}
