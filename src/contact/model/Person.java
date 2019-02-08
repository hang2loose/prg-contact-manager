package contact.model;

enum Gender {
  NONE("n"), DIVERSE("d"), FEMALE("f"), MALE("m");

  private String representation;

  Gender(String representation) {
    this.representation = representation;
  }

  public static Gender fromString(String representation) {
    for (Gender gender : Gender.values()) {
      if (gender.representation.equalsIgnoreCase(representation)) {
        return gender;
      }
    }
    throw new IllegalArgumentException("Representation of Gender not allowed!!!!");
  }

}

public class Person {
  private String surname;
  private String name;

  private String title;
  private String birthdate;

  private Gender gender;

  Person(String surname, String name, String title, String birthdate,
      Gender gender) {
    this.surname = surname;
    this.name = name;
    this.title = title;
    this.birthdate = birthdate;
    this.gender = gender;
  }

  public PersonBuilder getPersonBuilder(String name, String surname) {
    return new PersonBuilder(name, surname);
  }
}
