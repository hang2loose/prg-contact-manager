package contact.services;

import contact.model.Address;
import contact.model.Communication;
import contact.model.ContactCard;
import contact.model.Person;
import contact.repository.ContactRepository;

class DummyDataCreator {

  private DummyDataCreator() {
  }

  static void createDummyContacts(ContactRepository repository) {

    ContactCard contact1 = ContactCard.getContactCardBuilder()
        .withPerson(
            Person
                .getPersonBuilder()
                .withName("Burggraf")
                .withSurname("Marco")
                .withBirthdate("10.10.10")
                .build())
        .withAddress(
            Address
                .getAddressBuilder()
                .withCity("city")
                .withCountry("Germany")
                .build())
        .withCommunication(Communication
            .getCommunicationBuilder()
            .withPhone("001 999999")
            .withMail("mail@mail.de")
            .build())
        .build();
    repository.save(contact1);

    ContactCard contact2 = ContactCard.getContactCardBuilder()
        .withPerson(Person.getPersonBuilder()
            .withName("Elsner")
            .withSurname("Dorothee")
            .build())
        .withCommunication(Communication.getCommunicationBuilder()
            .withMail("diri_elsi@gmx.de)")
            .withPhone("07665 112233").build())
        .withAddress(Address.getAddressBuilder()
            .withCity("HomeTown")
            .withZipCode("79227")
            .withStreet("Laternenstrasse 1")
            .withStreetNumber("1")
            .build())
        .build();
    repository.save(contact2);


  }

}
