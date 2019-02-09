package contact.repository;

import contact.model.ContactCard;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ContactRepository {

  ContactCard getContactByID(UUID id);

  Collection<ContactCard> getAllContacts();

  void save(ContactCard contactCard);

  void saveAll(List<ContactCard> contactCardList);

  void deleteContactCard(UUID id);

  void editContactCard(UUID id, ContactCard contactCard);

  Collection<ContactCard> getContactCardWithLastName(String name);

  Collection<ContactCard> getContactCardWithSurName(String surName);


}
