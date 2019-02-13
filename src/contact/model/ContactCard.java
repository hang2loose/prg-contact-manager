package contact.model;

import java.io.Serializable;
import java.util.UUID;

public class ContactCard implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  Person person;
  Communication communication;
  Address address;

  ContactCard() {
    this.id = UUID.randomUUID();
  }

  public UUID getUid() {
    return id;
  }

  public Person getPerson() {
    return person;
  }

  public Communication getCommunication() {
    return communication;
  }

  public Address getAddress() {
    return address;
  }

  public String getPersonName() {
    return person.name;
  }

  public String getPersonSurname() {
    return person.surname;
  }

  public ContactCardBuilder getEditContactCard() {
    return new ContactCardBuilder(this);
  }

  public static ContactCardBuilder getContactCardBuilder() {
    return new ContactCardBuilder();
  }
}
