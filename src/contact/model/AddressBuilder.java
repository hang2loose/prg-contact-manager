package contact.model;

import java.io.Serializable;

public class AddressBuilder implements Serializable {

  private Address addressUnderConstruction;

  AddressBuilder() {
    this.addressUnderConstruction = new Address();
  }

  AddressBuilder(Address addressUnderConstruction) {
    this.addressUnderConstruction = addressUnderConstruction;
  }

  public AddressBuilder withCountry(String country) {
    addressUnderConstruction.country = country;
    return this;
  }

  public AddressBuilder withCity(String city) {
    addressUnderConstruction.city = city;
    return this;
  }

  public AddressBuilder withZipCode(String zipCode) {
    addressUnderConstruction.zipCode = zipCode;
    return this;
  }

  public AddressBuilder withStreet(String street) {
    addressUnderConstruction.street = street;
    return this;
  }

  public AddressBuilder withStreetNumber(String streetNumber) {
    addressUnderConstruction.streetNumber = streetNumber;
    return this;
  }

  public Address build() {
    return addressUnderConstruction;
  }


}
