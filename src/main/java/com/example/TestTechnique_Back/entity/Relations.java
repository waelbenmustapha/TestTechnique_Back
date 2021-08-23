package com.example.TestTechnique_Back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Relations {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
@OneToOne
  private Person personne;
@OneToOne
  private Person relative;
  private String relation;

  public Relations(){}
}
