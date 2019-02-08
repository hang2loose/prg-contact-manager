package contact;

import contact.model.Address;
import contact.model.AddressBuilder;
import contact.model.Communication;
import contact.model.Person;

public class ContactCardBuilder {

  private Address address;
  private Communication communication;
  private Person person;

  private ContactCardBuilder(Address address, Person person, Communication communication) {
    this.address = address;
    this.communication = communication;
    this.person = person;
  }

  ContactCardBuilder buildAddress() {
    this.address = AddressBuilder
    return this;
  }

  ContactCard buildContactCard() {
    return new ContactCard(address, communication, person);
  }

}
