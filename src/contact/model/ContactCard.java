package contact.model;

import java.util.UUID;

public class ContactCard {

  private UUID id;

  Address address;
  Communication communication;
  Person person;

  ContactCard() {
    this.id = UUID.randomUUID();
  }

  public UUID getUID() {
    return this.id;
  }
}
