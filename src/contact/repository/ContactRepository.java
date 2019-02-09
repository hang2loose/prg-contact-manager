package contact.repository;

import contact.model.ContactCard;

public interface ContactRepository {

  ContactCard getContactByID(int id);

  boolean save(ContactCard contactCard);
}
