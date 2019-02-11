package contact.model;

import java.io.Serializable;
import java.util.UUID;

public class ContactCard implements Serializable {

  private UUID id;

  Address address;
  Communication communication;
  Person person;

  ContactCard() {
    this.id = UUID.randomUUID();
  }

  public UUID getUid() {
    return id;
  }

  public Address getAddress() {
    return address;
  }

  public Communication getCommunication() {
    return communication;
  }

  public Person getPerson() {
    return person;
  }

  public String getPersonName() {
    return person.name;
  }

  public ContactCardBuilder getEditContactCard() {
    return new ContactCardBuilder(this);
  }

  public static ContactCardBuilder getContactCardBuilder() {
    return new ContactCardBuilder();
  }
}
