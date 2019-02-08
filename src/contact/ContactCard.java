package contact;

import contact.model.Address;
import contact.model.Communication;
import contact.model.Person;
import java.util.UUID;

public class ContactCard {

  private UUID id;

  private Address address;
  private Person person;
  private Communication contact;

  private ContactCard() {
    this.id = UUID.randomUUID();
  }
}
