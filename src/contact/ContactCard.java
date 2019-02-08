package contact;

import contact.model.Address;
import contact.model.Communication;
import contact.model.Person;
import java.util.UUID;

public class ContactCard {

  private UUID id;

  private Address address;
  private Communication communication;
  private Person person;

  ContactCard(Address address, Communication communication, Person person) {
    this.id = UUID.randomUUID();
    this.address = address;
    this.communication = communication;
    this.person = person;
  }

}
