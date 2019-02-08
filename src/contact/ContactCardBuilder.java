package contact;

import contact.model.Address;
import contact.model.Communication;
import contact.model.Person;

public class ContactCardBuilder {

  private ContactCard contactCardUnderConstruktion = new ContactCard();

  ContactCardBuilder withAddress(Address address) {
    contactCardUnderConstruktion.address = address;
    return this;
  }

  ContactCardBuilder withPerson(Person person) {
    contactCardUnderConstruktion.person = person;
    return this;
  }

  ContactCardBuilder withCommunication(Communication communication) {
    contactCardUnderConstruktion.communication = communication;
    return this;
  }

  ContactCard build() {
    return contactCardUnderConstruktion;
  }

}
