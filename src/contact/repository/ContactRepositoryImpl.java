package contact.repository;

import contact.model.ContactCard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ContactRepositoryImpl implements ContactRepository {

  private HashMap<UUID, ContactCard> contactCardMap = new HashMap<>();

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
    return contactCardMap.values().stream()
        .filter(contactCard -> name.equalsIgnoreCase(contactCard.getPerson().getName()))
        .collect(Collectors.toList());
  }

  @Override
  public Collection<ContactCard> getContactCardWithSurName(String surName) {
    return contactCardMap.values().stream()
        .filter(contactCard -> surName.equalsIgnoreCase(contactCard.getPerson().getSurname()))
        .collect(Collectors.toList());
  }

  @Override
  public int getSizeOfRepo() {
    return contactCardMap.size();
  }
}
