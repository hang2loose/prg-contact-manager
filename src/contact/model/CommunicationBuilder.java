package contact.model;

public class CommunicationBuilder {

  private Communication CommunicationUnderConstruction = new Communication();

  public CommunicationBuilder withPhone(String phone) {
    CommunicationUnderConstruction.phone = phone;
    return this;
  }

  public CommunicationBuilder withMail(String mail) {
    CommunicationUnderConstruction.mail = mail;
    return this;
  }

  public Communication build() {
    return CommunicationUnderConstruction;
  }

}
