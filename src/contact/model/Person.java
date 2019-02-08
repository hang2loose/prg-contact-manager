package contact.model;

import java.time.LocalDate;

enum Gender {
  FEMALE, DIVERSE, MALE
}

public class Person {
  private String surname;
  private String name;

  private String title;
  private LocalDate birthdate;

  private Gender gender;

  private Person(String surname, String name) {
    this.surname = surname;
    this.name = name;
  }

}
