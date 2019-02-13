package contact.model;

public class AddressBuilder {

  private Address addressUnderConstruction;

  AddressBuilder() {
    this.addressUnderConstruction = new Address();
  }

  AddressBuilder(Address addressUnderConstruction) {
    this.addressUnderConstruction = addressUnderConstruction;
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

  public Address build() {
    return addressUnderConstruction;
  }


}
