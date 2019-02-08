package contact.model;

public class PersonBuilder {

  private String surname;
  private String name;

  private String title = "";
  private String birthdate = "none";

  private Gender gender = Gender.NONE;

  PersonBuilder(String surname, String name) {
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

  PersonBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  PersonBuilder setBirthdate(String birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  Person buildPerson() {
    return new Person(surname, name, title, birthdate, gender);
  }
}
