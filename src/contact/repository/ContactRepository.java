package contact.repository;

import contact.model.ContactCard;
import java.util.UUID;

public interface ContactRepository {

  ContactCard getContactByID(UUID id);

  void save(ContactCard contactCard);
}
