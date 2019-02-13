package contact.model;

public class ContactCardBuilder {

  private ContactCard contactCardUnderConstruction;

  ContactCardBuilder() {
    this.contactCardUnderConstruction = new ContactCard();
  }

  ContactCardBuilder(ContactCard contactCardUnderConstruction) {
    this.contactCardUnderConstruction = contactCardUnderConstruction;
  }

  public ContactCardBuilder withPerson(Person person) {
    contactCardUnderConstruction.person = person;
    return this;
  }

  public ContactCardBuilder withCommunication(Communication communication) {
    contactCardUnderConstruction.communication = communication;
    return this;
  }

  public ContactCardBuilder withAddress(Address address) {
    contactCardUnderConstruction.address = address;
    return this;
  }

  public ContactCard build() {
    return contactCardUnderConstruction;
  }

}
