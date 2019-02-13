package contact.enums;

public enum SortableColums {
  SURNAME("Vorname"),
  NAME("Nachname");

  private String representation;

  SortableColums(String representation) {
    this.representation = representation;
  }

  public String getRepresentation() {
    return representation;
  }
}
