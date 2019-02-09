package contact.model;

public class ContactCardBuilder {

  private ContactCard contactCardUnderConstruction = new ContactCard();

  ContactCardBuilder withAddress(Address address) {
    contactCardUnderConstruction.address = address;
    return this;
  }

  ContactCardBuilder withPerson(Person person) {
    contactCardUnderConstruction.person = person;
    return this;
  }

  ContactCardBuilder withCommunication(Communication communication) {
    contactCardUnderConstruction.communication = communication;
    return this;
  }

  ContactCard build() {
    return contactCardUnderConstruction;
  }

}
