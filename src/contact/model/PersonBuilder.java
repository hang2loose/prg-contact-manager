package contact.model;

public class PersonBuilder {

  private Person personUnderConstruction = new Person();

  public PersonBuilder withName(String name) {
    personUnderConstruction.name = name;
    return this;
  }

  public PersonBuilder withSurname(String surname) {
    personUnderConstruction.surname = surname;
    return this;
  }

  public PersonBuilder withGender(String gender) {
    personUnderConstruction.gender = Gender.fromString(gender);
    return this;
  }

  public PersonBuilder withTitle(String title) {
    personUnderConstruction.title = title;
    return this;
  }

  public PersonBuilder withBirthdate(String birthday) {
    personUnderConstruction.birthday = birthday;
    return this;
  }

  public Person build() {
    return personUnderConstruction;
  }
}
