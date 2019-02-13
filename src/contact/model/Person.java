package contact.model;

import java.io.Serializable;

public class Person implements Serializable {
  String surname = "";
  String name = "";

  Person() {
  }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }

  public static PersonBuilder getPersonBuilder() {
    return new PersonBuilder();
  }
}
