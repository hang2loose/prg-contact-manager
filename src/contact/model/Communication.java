package contact.model;

public class Communication {

  String phone = "";
  String mail = "";

  Communication() {
  }

  public String getPhone() {
    return phone;
  }

  public String getMail() {
    return mail;
  }

  public static CommunicationBuilder getCommunicationBuilder() {
    return new CommunicationBuilder();
  }

}
