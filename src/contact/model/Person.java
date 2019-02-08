package contact.model;

import java.time.LocalDate;

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
  private LocalDate birthdate;

  private Gender gender;

  private Person(String surname, String name, String title, LocalDate birthdate,
      Gender gender) {
    this.surname = surname;
    this.name = name;
    this.title = title;
    this.birthdate = birthdate;
    this.gender = gender;
  }
}
