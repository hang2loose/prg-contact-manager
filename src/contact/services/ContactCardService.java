package contact.services;

import contact.model.Address;
import contact.model.Communication;
import contact.model.ContactCard;
import contact.model.Person;
import contact.repository.ContactRepository;
import contact.repository.ContactRepositoryImpl;
import java.util.HashMap;
import java.util.stream.Collectors;

// TODO implement as Singleton
public class ContactCardService {

  private ContactRepository contactRepository;

  public ContactCardService() {
    this.contactRepository = new ContactRepositoryImpl();
  }

  public void addContactCardToRepo(ContactCard contactCard) {
    contactRepository.save(contactCard);
  }

  // TODO delete this method
  public ContactCard getRandomContact() {
    return (ContactCard) contactRepository.getAllContacts();
  }

  public void initRepoWithDummyData() {
    DummyDataCreator.createDummyContacts(contactRepository);
  }

  public String getAllLastNames() {
    return contactRepository.getAllContacts().stream()
        .map(contacts -> contacts.getPerson().getName())
        .collect(Collectors.toList()).toString();
  }

  public void createNewContact(HashMap<String, String> newContactInformations) {
    ContactCard newContactCard = ContactCard.getContactCardBuilder()
        .withPerson(Person.getPersonBuilder()
            .withSurname(newContactInformations.get("surname"))
            .withName(newContactInformations.get("name"))
            .build())
        .withAddress(Address.getAddressBuilder()
            .withCity(newContactInformations.get("city"))
            .withZipCode(newContactInformations.get("zip"))
            .withStreet("street")
            .build())
        .withCommunication(Communication.getCommunicationBuilder()
            .withPhone(newContactInformations.get("phoneNumber"))
            .withMail(newContactInformations.get("eMail")).build())
        .build();

    contactRepository.save(newContactCard);
  }
}
