package com.example.TestTechnique_Back.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String prenom;
  private String civilite;
  private Date naissance;
  private String situationFamiliale;
  private Integer nmbrenfants;
  private String email;
  private String phone1;
  private String phone2;
  private String mobile;
  private String adresse;
  private String pays;
  private String ville;
  private String rue;
  private String numRue;
  private String codePostal;
  private String complementadresse;
  private String motCles;
  private String commentaire;
  public Person(){}

}
