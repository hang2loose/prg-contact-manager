package contact.model;

public class CommunicationBuilder {

  private String phone;
  private String mail = "";

  CommunicationBuilder(String phone) {
    this.phone = phone;
  }

  CommunicationBuilder setMail(String mail) {
    this.mail = mail;
    return this;
  }

  Communication buildComunication() {
    return new Communication(phone, mail);
  }

}
