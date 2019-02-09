package contact.services;

import contact.repository.ContactRepository;

// TODO implement as Singleton
public class ContactCardService {

  private ContactRepository contactRepository;

  public ContactCardService(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }


}
