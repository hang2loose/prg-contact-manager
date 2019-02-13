package contact.enums;

public enum SortableColums {
  NAME("Nachname"), SURNAME("Vorname");

  private String representation;

  SortableColums(String representation) {
    this.representation = representation;
  }

  public String getRepresentation() {
    return representation;
  }
}
