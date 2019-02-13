package contact;

import contact.enums.ManagerState;
import contact.enums.SortableColums;
import contact.enums.SortingOrder;
import java.util.HashMap;
import java.util.Scanner;

class InputHandler {

  private Scanner scanner = new Scanner(System.in);

  ManagerState getInput() {
    prtintCommands();

    System.out.print("> ");
    char command = getCharacterCommand();

    switch (command) {
      case 'a':
        return ManagerState.GET_ALL_CONTACTS;
      case 'o':
        return ManagerState.GET_CONTACT_IN_ORDER;
      case 'n':
        return ManagerState.CREATE_NEW_CONTACT;
      case 'k':
        return ManagerState.EDIT_CONTACT;
      case 'd':
        return ManagerState.PRINT_CONTACT_DETAILS;
      case 's':
        return ManagerState.GET_CONTACT_BY_SEARCH_PARAM;
      case 'l':
        return ManagerState.DELETE_CONTACT;
      case 'b':
        return ManagerState.END;
      default:
        System.out.println(command + " is not an valid command for this Manager");
        return ManagerState.GET_COMMAND;
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

  HashMap<String, String> getNewContactInformation() {
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

    if (!askForConfirmation()) {
      newContactInformations.clear();
    }
    return newContactInformations;
  }

  private boolean askForConfirmation() {
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
        return askForConfirmation();
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

  int getContactIndex(ManagerState state) {
    switch (state) {
      case EDIT_CONTACT:
        System.out.println("\n\n");
        System.out.print("Welchen Kontakt möchten sie bearbeiten? ");
        break;
      case DELETE_CONTACT:
        System.out.println("\n\n");
        System.out.print("Welchen Kontakt möchten sie löschen? ");
        break;
      case PRINT_CONTACT_DETAILS:
        System.out.println("\n\n");
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

  private String readParameter() {
    return scanner.nextLine();
  }

  SortableColums getColumn() {
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
        return getColumn();
    }
  }

  SortingOrder getOrder(SortableColums columName) {
    System.out.println("Wie soll die Spalte " + columName.getRepresentation() + " sortiert sein?");
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

  String readSearchParameter() {
    System.out.print("Geben Sie einen Suchbegriff ein: ");
    return readParameter().toLowerCase();
  }
}
