package contact.repository;

import contact.model.ContactCard;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ContactRepositoryImpl implements ContactRepository, Serializable {

  private static ContactRepositoryImpl contactRepositoryImpl = null;

  public static ContactRepositoryImpl getInstance() {

    if (contactRepositoryImpl == null) {
      contactRepositoryImpl = new ContactRepositoryImpl();
    }
    return contactRepositoryImpl;
  }

  private static final long serialVersionUID = 1L;
  private HashMap<UUID, ContactCard> contactCardMap = new HashMap<>();

  private ContactRepositoryImpl() {
  }

  @Override
  public ContactCard getContactById(UUID id) {
    return contactCardMap.getOrDefault(id, null);
  }

  @Override
  public void save(ContactCard contactCard) {
    contactCardMap.put(contactCard.getUid(), contactCard);
  }

  @Override
  public void saveAll(List<ContactCard> contactCardList) {
    contactCardList
        .forEach(contactCard -> contactCardMap.put(contactCard.getUid(), contactCard));
  }

  @Override
  public List<ContactCard> getAllContacts() {
    return new ArrayList<>(contactCardMap.values());
  }

  @Override
  public void deleteContactCard(UUID id) {
    contactCardMap.remove(id);
  }

  @Override
  public Collection<ContactCard> getContactCardWithLastName(String name) {
    return contactCardMap
        .values()
        .stream()
        .filter(contactCard -> name.equalsIgnoreCase(contactCard.getPerson().getName()))
        .collect(Collectors.toList());
  }

  @Override
  public Collection<ContactCard> getContactCardWithSurName(String surName) {
    return contactCardMap
        .values()
        .stream()
        .filter(contactCard -> surName.equalsIgnoreCase(contactCard.getPerson().getSurname()))
        .collect(Collectors.toList());
  }

  @Override
  public int getSizeOfRepo() {
    return contactCardMap.size();
  }

  @Override
  public boolean wirteRepo(String nameOfRepository) {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new FileOutputStream(nameOfRepository + ".ser"))) {
      outputStream.writeObject(contactCardMap);
    } catch (IOException exception) {
      return false;
    }
    return true;
  }

  @Override
  public boolean readRepo(String nameOfRepository) {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream(nameOfRepository + ".ser"))) {
      contactCardMap = (HashMap<UUID, ContactCard>) inputStream.readObject();
    } catch (ClassNotFoundException | IOException exception) {
      return false;
    }
    return true;
  }

  @Override
  public List<ContactCard> getListWithSearchParam(String searchParam) {
    return contactCardMap.values().stream()
        .filter(contactCard -> paramContainsInCard(contactCard, searchParam))
        .collect(Collectors.toList());
  }

  private boolean paramContainsInCard(ContactCard contactCard, String searchParam) {

    return true;
  }
}
