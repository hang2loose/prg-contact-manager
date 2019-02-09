package contact.model;

public class PersonBuilder {

  private Person personUnderConstruction = new Person();

  PersonBuilder withGender(String gender) {
    personUnderConstruction.gender = Gender.fromString(gender);
    return this;
  }

  PersonBuilder withTitle(String title) {
    personUnderConstruction.title = title;
    return this;
  }

  PersonBuilder withBirthdate(String birthday) {
    personUnderConstruction.birthday = birthday;
    return this;
  }

  Person build() {
    return personUnderConstruction;
  }
}
