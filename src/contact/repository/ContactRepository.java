package contact.repository;

import contact.model.ContactCard;

public interface ContactRepository {

  ContactCard getContactByID(int id);

  void save(ContactCard contactCard);
}
