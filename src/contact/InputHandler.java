package contact;

import contact.enums.SortableColums;
import contact.enums.SortingOrder;
import java.util.HashMap;
import java.util.Scanner;

class InputHandler {

  private Scanner scanner = new Scanner(System.in);

  StateOfManager getInput() {
    prtintCommands();

    System.out.print("> ");
    char command = getCharacterCommand();

    switch (command) {
      case 'a':
        return StateOfManager.GET_ALL_CONTACTS;
      case 'n':
        return StateOfManager.CREATE_NEW_CONTACT;
      case 'k':
        return StateOfManager.EDIT_CONTACT;
      case 'd':
        return StateOfManager.PRINT_CONTACT_DETAILS;
      case 'l':
        return StateOfManager.DELETE_CONTACT;
      case 'o':
        return StateOfManager.GET_CONTACT_IN_ORDER;
      case 's':
        return StateOfManager.GET_CONTACT_BY_SEARCH_PARAM;
      case 'b':
        return StateOfManager.END;
      default:
        System.out.println(command + " is not an valid command for this Manager");
        return StateOfManager.GET_COMMAND;
    }
  }

  private static void prtintCommands() {
    System.out.println("\n\n");
    System.out.println("[A] Alle Kontakte anzeigen");
    System.out.println("[O] Alle Kontakte Sortiert");
    System.out.println("[N] Neuen Kontakt erstellen");
    System.out.println("[K] Kontakt bearbeiten");
    System.out.println("[D] Kontaktdetails anzeigen");
    System.out.println("[S] Kontakt suchen");
    System.out.println("[L] Kontakt loeschen");
    System.out.println("[B] Beenden");
  }

  HashMap<String, String> getNewContactInformations() {
    HashMap<String, String> newContactInformations = new HashMap<>();
    System.out.print("Vorname: ");
    newContactInformations.put("surname", readParameter());

    System.out.print("Nachname: ");
    newContactInformations.put("name", readParameter());

    System.out.print("Telefon: ");
    newContactInformations.put("phoneNumber", readParameter());

    System.out.print("eMail: ");
    newContactInformations.put("eMail", readParameter());

    System.out.print("Strasse: ");
    newContactInformations.put("street", readParameter());

    System.out.print("PLZ: ");
    newContactInformations.put("zip", readParameter());

    System.out.print("Stadt: ");
    newContactInformations.put("city", readParameter());
    System.out.println();

    if (!askForComfirmation()) {
      newContactInformations.clear();
    }
    return newContactInformations;
  }

  private boolean askForComfirmation() {
    System.out.println("[S] Änderung speichern ");
    System.out.println("[A] Abbrechen? ");

    char input = getCharacterCommand();

    switch (input) {
      case 'a':
        return false;
      case 's':
        return true;
      default:
        System.out.println(input + " Character not a Command!");
        return askForComfirmation();
    }
  }

  private char getCharacterCommand() {
    String inputString = scanner.nextLine();
    while (inputString.length() != 1) {
      System.out.println("Please insert a character as command!\n ");
      inputString = scanner.nextLine();
    }
    return inputString.toLowerCase().charAt(0);
  }

  int getContactIndex(StateOfManager state) {
    switch (state) {
      case EDIT_CONTACT:
        System.out.print("Welchen Kontakt möchten sie bearbeiten? ");
        break;
      case DELETE_CONTACT:
        System.out.print("Welchen Kontakt möchten sie löschen? ");
        break;
      case PRINT_CONTACT_DETAILS:
        System.out.println("Welchen Kontakt möchten sie ansehen? ");
        break;
      default:
    }
    int input;
    try {
      input = Integer.valueOf(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Bitte nur Zahlen eingeben!!!\n ");
      return getContactIndex(state);
    }
    return input;
  }

  String getNameOfRepository() {
    System.out.println("Bitte gib den Namen für dein Addressbuch ein:");
    return readParameter().trim();
  }

  private String readParameter() {
    return scanner.nextLine();
  }

  public SortableColums getColum() {
    System.out.println("Nach welcher Spalte soll Sortiert werden?");
    System.out.println("[V] Vorname");
    System.out.println("[N] Nachname");

    char colum = getCharacterCommand();

    switch (colum) {
      case 'v':
        return SortableColums.SURNAME;
      case 'n':
        return SortableColums.NAME;
      default:
        System.out.println("Es kann nur nach Vor oder Nachname sortiert werden?");
        getColum();
    }
    return null;
  }

  public SortingOrder getOrder(SortableColums columName) {
    System.out.println("Wie soll die Spalte " + columName.name() + " sortiert sein?");
    System.out.println("[1] Aufsteigend");
    System.out.println("[2] Absteigend");

    switch (getCharacterCommand()) {
      case '1':
        return SortingOrder.ASCENDING;
      case '2':
        return SortingOrder.DECSENDING;
      default:
        return getOrder(columName);
    }
  }

  public String readSearchParameter() {
    System.out.print("Geben Sie einen Suchbegriff ein: ");
    return readParameter();
  }
}
