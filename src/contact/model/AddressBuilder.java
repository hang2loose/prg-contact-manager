package contact.model;

public class AddressBuilder {

  private String country = "";
  private String city = "";
  private String zipCode = "";
  private String street = "";
  private String streetNumber = "";

  private AddressBuilder() {

  }

  public AddressBuilder getAddressBuilder() {
    return new AddressBuilder();
  }

  AddressBuilder getCountry(String country) {
    this.country = country;
    return this;
  }

  AddressBuilder getCity(String city) {
    this.city = city;
    return this;
  }

  AddressBuilder getZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  AddressBuilder getStreet(String street) {
    this.street = street;
    return this;
  }

  AddressBuilder getStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

  Address buildAddress() {
    return new Address(country, city, zipCode, street, streetNumber);
  }

}
