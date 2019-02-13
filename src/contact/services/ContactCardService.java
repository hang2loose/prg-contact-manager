package contact.services;

import contact.enums.SortableColums;
import contact.enums.SortingOrder;
import contact.model.Address;
import contact.model.Communication;
import contact.model.ContactCard;
import contact.model.ContactCardBuilder;
import contact.model.Person;
import contact.repository.ContactRepository;
import contact.repository.ContactRepositoryImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ContactCardService {

  private static ContactCardService contactCardService = null;

  public static ContactCardService getInstance() {

    if (contactCardService == null) {
      contactCardService = new ContactCardService();
    }
    return contactCardService;
  }

  private ContactRepository contactRepository;

  private HashMap<Integer, UUID> representationMap = new HashMap<>();

  private ContactCardService() {
    this.contactRepository = ContactRepositoryImpl.getInstance();
    updateRepresentationMap();
  }

  private void updateRepresentationMap() {
    List<ContactCard> tmp = new ArrayList<>(contactRepository.getAllContacts());
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
    return cardBuilder
        .withPerson(Person.getPersonBuilder()
            .withSurname(newContactInformations.get("surname"))
            .withName(newContactInformations.get("name"))
            .build())
        .withAddress(Address.getAddressBuilder()
            .withCity(newContactInformations.get("city"))
            .withZipCode(newContactInformations.get("zip"))
            .withStreet(newContactInformations.get("street"))
            .build())
        .withCommunication(Communication.getCommunicationBuilder()
            .withPhone(newContactInformations.get("phoneNumber"))
            .withMail(newContactInformations.get("eMail"))
            .build())
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

  public boolean writeData(String nameOfRepository) {
    return contactRepository.wirteRepo(nameOfRepository);
  }

  public boolean readData(String nameOfRepository) {
    return contactRepository.readRepo(nameOfRepository);
  }

  public List<ContactCard> orderContacts(SortableColums column, SortingOrder order) {

    List<ContactCard> sortedList = getSortedContactList(column);

    if (order.equals(SortingOrder.DECSENDING)) {
      Collections.reverse(sortedList);
      return sortedList;
    }

    return sortedList;
  }

  private List<ContactCard> getSortedContactList(SortableColums colums) {
    switch (colums) {
      case SURNAME:
        return contactRepository.getAllContacts().stream()
            .sorted(
                Comparator.comparing(ContactCard::getPersonSurname, String::compareToIgnoreCase))
            .collect(Collectors.toList());
      case NAME:
        return contactRepository.getAllContacts().stream()
            .sorted(
                Comparator.comparing(ContactCard::getPersonName, String::compareToIgnoreCase))
            .collect(Collectors.toList());
      default:
        return contactRepository.getAllContacts();
    }
  }

  public List<ContactCard> getSearchResult(String readSearchParameter) {
    return contactRepository.getContactsBySearchParam(readSearchParameter);
  }
}