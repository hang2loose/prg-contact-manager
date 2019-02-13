package contact.repository;

import contact.model.ContactCard;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface ContactRepository extends Serializable {

  ContactCard getContactById(UUID id);

  List<ContactCard> getAllContacts();

  void save(ContactCard contactCard);

  void deleteContactCard(UUID id);

  boolean wirteRepo(String nameOfRepository);

  boolean readRepo(String nameOfRepository);

  List<ContactCard> getContactsBySearchParam(String searchParam);
}
