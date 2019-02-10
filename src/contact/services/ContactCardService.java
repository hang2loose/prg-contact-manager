package contact.services;

import contact.model.Address;
import contact.model.Communication;
import contact.model.ContactCard;
import contact.model.ContactCardBuilder;
import contact.model.Person;
import contact.repository.ContactRepository;
import contact.repository.ContactRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

// TODO implement as Singleton
public class ContactCardService {

  private ContactRepository contactRepository;

  private HashMap<Integer, UUID> representationMap = new HashMap<>();

  public ContactCardService() {
    this.contactRepository = new ContactRepositoryImpl();
  }

  public HashMap<Integer, UUID> getRepresentationMap() {
    return representationMap;
  }

  private void updateRepresentationMap() {
    List<ContactCard> tmp = contactRepository.getAllContacts();
    representationMap.clear();
    for (ContactCard contactCard : tmp) {
      representationMap.put(tmp.indexOf(contactCard), contactCard.getUid());
    }
  }

  public void initRepoWithDummyData() {
    DummyDataCreator.createDummyContacts(contactRepository);
  }

  // TODO should be removed when the TableManager is working
  public void printContactWithIndex() {
    updateRepresentationMap();
    representationMap.keySet()
        .forEach(a -> System.out.println(a + " " +
            contactRepository.getContactByID(representationMap.get(a)).getPerson().getName()));
  }

  public void createNewContact(HashMap<String, String> newContactInformations) {
    if (newContactInformations.isEmpty()) {
      return;
    }
    ContactCard newContactCard =
        fillContact(ContactCard.getContactCardBuilder(), newContactInformations);
    contactRepository.save(newContactCard);
  }

  public void editContactById(int contactIndex, HashMap<String, String> newContactInformations) {
    if (!(contactIndex > representationMap.size() || newContactInformations.isEmpty())) {
      ContactCard oldContactCard =
          contactRepository.getContactByID(representationMap.get(contactIndex));

      ContactCard newContactCard =
          fillContact(ContactCard.getEditContactCard(oldContactCard), newContactInformations);
      contactRepository.save(newContactCard);
    }
  }

  public boolean deleteContactByIndex(int contactIndex) {
    if (contactIndex > representationMap.size()) {
      return false;
    }
    contactRepository.deleteContactCard(representationMap.get(contactIndex));
    return true;
  }

  private ContactCard fillContact(ContactCardBuilder cardBuilder,
      HashMap<String, String> newContactInformations) {
    return cardBuilder.withPerson(Person.getPersonBuilder()
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
  }
}
