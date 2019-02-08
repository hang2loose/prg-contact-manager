package contact.model;

public class CommunicationBuilder {

  private Communication CommunicationUnderConstruction = new Communication();

  CommunicationBuilder withPhone(String phone) {
    CommunicationUnderConstruction.phone = phone;
    return this;
  }

  CommunicationBuilder withMail(String mail) {
    CommunicationUnderConstruction.mail = mail;
    return this;
  }

  Communication build() {
    return CommunicationUnderConstruction;
  }

}
