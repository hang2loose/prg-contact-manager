package contact.services;

import contact.model.ContactCard;
import contact.repository.ContactRepository;

// TODO implement as Singleton
public class ContactCardService {

  private ContactRepository contactRepository;

  public ContactCardService(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }


  public boolean addContactCardToRepo(ContactCard contactCard) {

    return false;
  }

  public void initRepoWithDummyData() {
    DummyDataCreator.createDummyContacts(contactRepository);
  }
}
