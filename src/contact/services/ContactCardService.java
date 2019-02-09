package contact.services;

import contact.model.ContactCard;
import contact.repository.ContactRepository;
import contact.repository.ContactRepositoryImpl;
import java.util.stream.Collectors;

// TODO implement as Singleton
public class ContactCardService {

  private ContactRepository contactRepository;

  public ContactCardService() {
    this.contactRepository = new ContactRepositoryImpl();
  }

  public void addContactCardToRepo(ContactCard contactCard) {
    contactRepository.save(contactCard);
  }

  // TODO delete this method
  public ContactCard getRandomContact() {
    return (ContactCard) contactRepository.getAllContacts();
  }

  public void initRepoWithDummyData() {
    DummyDataCreator.createDummyContacts(contactRepository);
  }

  public String getAllLastNames() {
    return contactRepository.getAllContacts().stream()
        .map(contacts -> contacts.getPerson().getName())
        .collect(Collectors.toList()).toString();
  }
}
