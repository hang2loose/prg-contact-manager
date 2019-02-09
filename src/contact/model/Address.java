package contact.model;

public class Address {

  String country = "";
  String city = "";
  String zipCode = "";
  String street = "";
  String streetNumber = "";

  Address() {
  }

  public String getCountry() {
    return country;
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

  public String getStreetNumber() {
    return streetNumber;
  }

  public static AddressBuilder getAddressBuilder() {
    return new AddressBuilder();
  }

}
