package contact.model;

public class ContactCardBuilder {

  private ContactCard contactCardUnderConstruction = new ContactCard();

  public ContactCardBuilder withAddress(Address address) {
    contactCardUnderConstruction.address = address;
    return this;
  }

  public ContactCardBuilder withPerson(Person person) {
    contactCardUnderConstruction.person = person;
    return this;
  }

  public ContactCardBuilder withCommunication(Communication communication) {
    contactCardUnderConstruction.communication = communication;
    return this;
  }

  public ContactCard build() {
    return contactCardUnderConstruction;
  }

}
