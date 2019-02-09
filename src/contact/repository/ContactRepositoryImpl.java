package contact.repository;

import contact.ContactManager;
import contact.model.ContactCard;
import java.util.HashMap;
import java.util.UUID;

public class ContactRepositoryImpl implements ContactRepository {

  private ContactManager contactManager;

  private HashMap<UUID, ContactCard> contactCardMap = new HashMap<>();

  public ContactRepositoryImpl(ContactManager contactManager) {
    this.contactManager = contactManager;
  }

  @Override
  public ContactCard getContactByID(int id) {
    return null;
  }

  @Override
  public void save(ContactCard contactCard) {
    contactCardMap.put(contactCard.getUID(), contactCard);
  }
}
