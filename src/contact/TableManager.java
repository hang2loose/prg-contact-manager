package contact;

import contact.model.ContactCard;
import java.util.List;

class TableManager {


  private TableManager() {
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

  public static void printContactsList(List<ContactCard> contactCardList) {
    firstTableRow();
    contactCardList
        .forEach(contactCard -> printCard(contactCard, contactCardList.indexOf(contactCard) + 1));
  }

  private static void firstTableRow() {
    System.out.printf("%19s%16s%26s%29s%n", "Surname", "Name", "Phone", "Mail");
    for (int i = 0; i < 90; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  private static void printCard(ContactCard contactCard, int index) {
    String name = getEllipsis(contactCard.getPerson().getName(), 15);
    String surName = getEllipsis(contactCard.getPerson().getSurname(), 15);
    ;
    String phone = getEllipsis(contactCard.getCommunication().getPhone(), 20);
    String mail = getEllipsis(contactCard.getCommunication().getMail(), 22);
    System.out.printf("%d%19s%16s%26s%29s%n", index, surName, name, phone, mail);
  }


  private static String getEllipsis(String inputString, int maxLenght) {
    if (inputString.length() <= maxLenght - 3) {
      return inputString;
    }
    return inputString.substring(0, maxLenght - 3) + "...";
  }

}
