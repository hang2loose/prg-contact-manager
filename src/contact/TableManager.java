package contact;

import contact.model.ContactCard;

class TableManager {

  private TableManager() {
  }

  public static void firstTableRow() {
    System.out.printf("%19s%16s%26s%29s%n", "Surname", "Name", "Phone", "Mail");
    for (int i = 0; i < 90; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printContactCard(ContactCard contactCard) {
    System.out.println("| " + contactCard.getPerson().getSurname());
    System.out.println("| " + contactCard.getPerson().getName());
    System.out.println("| " + contactCard.getCommunication().getPhone());
    System.out.println("| " + contactCard.getCommunication().getMail());
    System.out.println();
    System.out.println("| " + contactCard.getAddress().getStreet());
    System.out.println(
        "| " + contactCard.getAddress().getZipCode() + " " + contactCard.getAddress().getCity());
  }
}
