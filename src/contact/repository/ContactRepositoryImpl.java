package contact.repository;

import contact.ContactManager;
import contact.model.ContactCard;

public class ContactRepositoryImpl implements ContactRepository {

  private ContactManager contactManager;

  public ContactRepositoryImpl(ContactManager contactManager) {
    this.contactManager = contactManager;
  }

  @Override
  public ContactCard getContactByID(int id) {
    return null;
  }

  @Override
  public boolean save(ContactCard contactCard) {
    return false;
  }
}
