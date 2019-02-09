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
  String surname = "";
  String name = "";

  String title = "";
  String birthday = "";

  Gender gender = Gender.NONE;

  Person() {
  }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }

  public String getTitle() {
    return title;
  }

  public String getBirthday() {
    return birthday;
  }

  public Gender getGender() {
    return gender;
  }

  public static PersonBuilder getPersonBuilder() {
    return new PersonBuilder();
  }
}
