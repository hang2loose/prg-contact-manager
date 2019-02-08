package contact.model;

public class Address {

  private String country;
  private String city;
  private String zipCode;
  private String street;
  private String streetNumber;

  Address(String country, String city, String zipCode, String street,
      String streetNumber) {
    this.country = country;
    this.city = city;
    this.zipCode = zipCode;
    this.street = street;
    this.streetNumber = streetNumber;
  }
}
