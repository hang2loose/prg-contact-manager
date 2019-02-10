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
import java.util.stream.Collectors;

// TODO implement as Singleton
public class ContactCardService {

  private ContactRepository contactRepository;

  private HashMap<Integer, UUID> representationMap = new HashMap<>();

  public ContactCardService() {
    this.contactRepository = new ContactRepositoryImpl();
    updateRepresentationMap();
  }

  public HashMap<Integer, UUID> getRepresentationMap() {
    return representationMap;
  }

  private void updateRepresentationMap() {
    List<ContactCard> tmp = contactRepository.getAllContacts();
    representationMap.clear();
    for (ContactCard contactCard : tmp) {
      representationMap.put(tmp.indexOf(contactCard) + 1, contactCard.getUid());
    }
  }

  public void initRepoWithDummyData() {
    DummyDataCreator.createDummyContacts(contactRepository);
    updateRepresentationMap();
  }

  public void createNewContact(HashMap<String, String> newContactInformations) {
    if (newContactInformations.isEmpty()) {
      return;
    }
    ContactCard newContactCard =
        fillContact(ContactCard.getContactCardBuilder(), newContactInformations);
    saveToRepository(newContactCard);
  }

  public void editContactById(int contactIndex, HashMap<String, String> newContactInformations) {
    if ((repoContainsIndex(contactIndex) && !newContactInformations.isEmpty())) {
      ContactCard oldContactCard =
          contactRepository.getContactById(getUuidFromIndex(contactIndex));
      ContactCard newContactCard =
          fillContact(oldContactCard.getEditContactCard(), newContactInformations);
      saveToRepository(newContactCard);
    }
  }

  public void deleteContactByIndex(int contactIndex) {
    if (repoContainsIndex(contactIndex)) {
      contactRepository.deleteContactCard(getUuidFromIndex(contactIndex));
    }
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

  public boolean repoContainsIndex(int contactIndex) {
    return representationMap.containsKey(contactIndex);
  }

  private UUID getUuidFromIndex(int contactIndex) {
    return representationMap.get(contactIndex);
  }

  private void saveToRepository(ContactCard newContactCard) {
    contactRepository.save(newContactCard);
  }

  public ContactCard getContactCardFromIndex(int contactIndex) {
    return contactRepository.getContactById(getUuidFromIndex(contactIndex));
  }

  public List<ContactCard> getAllCards() {
    updateRepresentationMap();
    return representationMap.keySet().stream().sorted()
        .map(this::getContactCardFromIndex)
        .collect(Collectors.toList());
  }
}
