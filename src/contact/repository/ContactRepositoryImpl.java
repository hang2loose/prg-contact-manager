package contact.repository;

import contact.model.ContactCard;
import java.util.HashMap;
import java.util.UUID;

public class ContactRepositoryImpl implements ContactRepository {

  private HashMap<UUID, ContactCard> contactCardMap = new HashMap<>();

  @Override
  public ContactCard getContactByID(UUID id) {
    return contactCardMap.getOrDefault(id, null);
  }

  @Override
  public void save(ContactCard contactCard) {
    contactCardMap.put(contactCard.getUID(), contactCard);
  }
}
