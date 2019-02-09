package contact.model;

public class Communication {

  String phone = "";
  String mail = "";

  Communication() {
  }

  public static CommunicationBuilder getCommunicationBuilder() {
    return new CommunicationBuilder();
  }

}
