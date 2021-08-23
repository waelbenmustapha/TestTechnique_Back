package com.example.TestTechnique_Back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.TestTechnique_Back.entity.Relations;

public interface RelationsRepository extends CrudRepository<Relations,Long> {

  List<Relations> findByPersonneId(Long id);

}
