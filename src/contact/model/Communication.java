package contact.model;

import java.io.Serializable;

public class Communication implements Serializable {

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
