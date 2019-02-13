package contact.model;

public class PersonBuilder {

  private Person personUnderConstruction;

  PersonBuilder() {
    this.personUnderConstruction = new Person();
  }

  public PersonBuilder withName(String name) {
    personUnderConstruction.name = name;
    return this;
  }

  public PersonBuilder withSurname(String surname) {
    personUnderConstruction.surname = surname;
    return this;
  }

  public Person build() {
    return personUnderConstruction;
  }
}
