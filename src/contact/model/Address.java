package contact.model;

import java.io.Serializable;

public class Address implements Serializable {

  String city = "";
  String zipCode = "";
  String street = "";

  Address() {
  }

  public String getCity() {
    return city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getStreet() {
    return street;
  }

  public static AddressBuilder getAddressBuilder() {
    return new AddressBuilder();
  }

  @Override
  public String toString() {
    return city + " " + zipCode + " " + street + " ";
  }
}
