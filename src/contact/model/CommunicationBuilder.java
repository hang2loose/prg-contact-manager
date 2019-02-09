package contact.model;

public class CommunicationBuilder {

  private Communication communicationUnderConstruction;

  public CommunicationBuilder() {
    this.communicationUnderConstruction = new Communication();
  }

  public CommunicationBuilder(Communication communicationUnderConstruction) {
    this.communicationUnderConstruction = communicationUnderConstruction;
  }

  public CommunicationBuilder withPhone(String phone) {
    communicationUnderConstruction.phone = phone;
    return this;
  }

  public CommunicationBuilder withMail(String mail) {
    communicationUnderConstruction.mail = mail;
    return this;
  }

  public Communication build() {
    return communicationUnderConstruction;
  }

}
