package contact.model;

public class PersonBuilder {

  private Person personUnderConstruction;

  public PersonBuilder() {
    this.personUnderConstruction = new Person();
  }

  public PersonBuilder(Person personUnderConstruction) {
    this.personUnderConstruction = personUnderConstruction;
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
