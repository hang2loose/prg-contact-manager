package contact.model;

public class Communication {

  private String phone;
  private String mail;

  Communication(String phone, String mail) {
    this.phone = phone;
    this.mail = mail;
  }

  public CommunicationBuilder getCommunicationBuilder(String phone) {
    return new CommunicationBuilder(phone);
  }

}
