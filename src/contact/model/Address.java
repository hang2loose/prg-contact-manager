package contact.model;

public class Address {

  String country;
  String city;
  String zipCode;
  String street;
  String streetNumber;

  Address() {
  }

  public static AddressBuilder getAddressBuilder() {
    return new AddressBuilder();
  }

}
