package contact.model;

public class CommunicationBuilder {

  private String phone;
  private String mail = "";

  private CommunicationBuilder(String phone) {
    this.phone = phone;
  }

  public CommunicationBuilder getCommunicationBuilder(String phone) {
    return new CommunicationBuilder(phone);
  }

  CommunicationBuilder setMail(String mail) {
    this.mail = mail;
    return this;
  }

  Communication buildComunication() {
    return new Communication(phone, mail);
  }

}
