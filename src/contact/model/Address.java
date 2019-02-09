package contact.model;

public class Address {

  String country;
  String city;
  String zipCode;
  String street;
  String streetNumber;

  Address() {
  }

  public AddressBuilder getAddressBuilder() {
    return new AddressBuilder();
  }

  public class AddressBuilder {

    private Address addressUnderConstruction = new Address();

    AddressBuilder withCountry(String country) {
      addressUnderConstruction.country = country;
      return this;
    }

    AddressBuilder withCity(String city) {
      addressUnderConstruction.city = city;
      return this;
    }

    AddressBuilder withZipCode(String zipCode) {
      addressUnderConstruction.zipCode = zipCode;
      return this;
    }

    AddressBuilder withStreet(String street) {
      addressUnderConstruction.street = street;
      return this;
    }

    AddressBuilder withStreetNumber(String streetNumber) {
      addressUnderConstruction.streetNumber = streetNumber;
      return this;
    }

    Address build() {
      return addressUnderConstruction;
    }


  }

}
