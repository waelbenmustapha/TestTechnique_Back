package com.example.TestTechnique_Back;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.TestTechnique_Back.entity.Person;
import com.example.TestTechnique_Back.repository.PersonReopistory;

@SpringBootTest
class TestTechniqueBackApplicationTests {

  @Autowired
  PersonReopistory personReopistory;

  @Test
  void contextLoads() {
  }

  @Test
  @DisplayName("ajouter suppresion récuperation person")
  void TestAjoutPerson() {
    //create person 1 with all fields
    Person person1 = new Person(99L, "test", "testprenom", "M", new Date(), "test", 2, "unittestuser", "hi", "ok", "nice", "good", "test", "data",
        "is it", "good", "work", "finally", "last", "comment");
    //create person 2 with some empty fields
    Person person2 = new Person(100L, "test2", "testprenom", "Mme", new Date(), null, 0, "unittest2", "hi", null, "nice", null, "test", "data",
        "is it", null, "work", "finally", "last", null);
    personReopistory.save(person1);
    personReopistory.save(person2);
    Assert.assertNotNull("check if first user is saved to the database", personReopistory.findByEmail("unittestuser"));
    Assert.assertNotNull("check if second user is saved to the database", personReopistory.findByEmail("unittest2"));
    personReopistory.delete(personReopistory.findByEmail("unittestuser"));
    personReopistory.delete(personReopistory.findByEmail("unittest2"));
    Assert.assertNull(personReopistory.findByEmail("unittestuser"));
    Assert.assertNull(personReopistory.findByEmail("unittest2"));
  }

}
