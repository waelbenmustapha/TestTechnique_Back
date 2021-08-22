package com.example.TestTechnique_Back.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.TestTechnique_Back.entity.Person;

public interface PersonReopistory extends CrudRepository<Person,Long> {

  Person findByEmail(String email);


}
