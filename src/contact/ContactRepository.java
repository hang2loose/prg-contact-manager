package contact;

public interface ContactRepository {

  ContactCard getContactByID(int id);

  boolean save(ContactCard contactCard);
}
