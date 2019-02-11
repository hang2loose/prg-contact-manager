package contact.repository;

import contact.model.ContactCard;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ContactRepository extends Serializable {

  ContactCard getContactById(UUID id);

  List<ContactCard> getAllContacts();

  void save(ContactCard contactCard);

  void saveAll(List<ContactCard> contactCardList);

  void deleteContactCard(UUID id);

  Collection<ContactCard> getContactCardWithLastName(String name);

  Collection<ContactCard> getContactCardWithSurName(String surName);

  int getSizeOfRepo();

}
