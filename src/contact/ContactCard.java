package contact;

import contact.model.Address;
import contact.model.Communication;
import contact.model.Person;
import java.util.UUID;

public class ContactCard {

  private UUID id;

  Address address;
  Communication communication;
  Person person;

  ContactCard() {
  }

}
