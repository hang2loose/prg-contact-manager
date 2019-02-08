package contact.model;

import java.time.LocalDate;

public class PersonBuilder {

  private String surname;
  private String name;

  private String title = "";
  private LocalDate birthdate = null;

  private Gender gender = Gender.NONE;

  private PersonBuilder(String surname, String name) {
    this.surname = surname;
    this.name = name;
  }

  public PersonBuilder getPersonBuilder(String name, String surname) {
    return new PersonBuilder(name, surname);
  }

  PersonBuilder setGender(String gender) {
    this.gender = Gender.fromString(gender);
    return this;
  }
}
