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
                .withCity("Freiburg")
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
            .withPhone("07665 112233")
            .build())
        .withAddress(Address.getAddressBuilder()
            .withCity("HomeTown")
            .withZipCode("79227")
            .withStreet("Laternenstrasse 1")
            .withStreetNumber("1")
            .build())
        .build();
    repository.save(contact2);

    ContactCard contact3 = ContactCard.getContactCardBuilder()
        .withPerson(Person.getPersonBuilder()
            .withName("Jethro")
            .withSurname("Hero")
            .withBirthdate("01.01.1970")
            .withGender("D")
            .build())
        .withCommunication(Communication.getCommunicationBuilder()
            .withMail("awesomeDude@heroes.org")
            .withPhone("001-900-BE-A-HERO")
            .build())
        .withAddress(Address.getAddressBuilder()
            .withCity("Gotham City")
            .withZipCode("000001")
            .withStreet("Worlds End")
            .withStreetNumber("101")
            .build())
        .build();
    repository.save(contact3);
  }
}
