package contact;

import java.util.HashMap;
import java.util.Scanner;

class InputHandler {

  private Scanner scanner = new Scanner(System.in);

  StateOfManager getInput(StateOfManager state) {
    prtintCommands();

    System.out.print("> ");

    //TODO throw exception if string is longer than 1;
    char command = getCharacterCommand();

    switch (command) {
      case 'a':
        return StateOfManager.GET_ALL_CONTACTS;
      case 'n':
        return StateOfManager.CREATE_NEW_CONTACT;
      case 'k':
        return StateOfManager.EDIT_CONTACT;
      case 'd':
        return StateOfManager.NOT_IMPLEMENTET_YET;
      case 'l':
        return StateOfManager.DELETE_CONTACT;
      case 'b':
        return StateOfManager.END;
      default:
        return StateOfManager.GET_COMMAND;
      //throw new InputMismatchException("The givin imput [" + command + "] is not a command");
    }
  }

  private static void prtintCommands() {
    System.out.println("\n\n");
    System.out.println("[A] Alle Kontakte anzeigen");
    System.out.println("[N] Neuen Kontakt erstellen");
    System.out.println("[K] Kontakt bearbeiten");
    System.out.println("[D] Kontaktdetails anzeigen");
    System.out.println("[L] Kontakt loeschen");
    System.out.println("[B] Beenden");
  }

  public HashMap<String, String> getNewContactInformations() {
    HashMap<String, String> newContactInformations = new HashMap<>();
    System.out.print("Vorname: ");
    newContactInformations.put("surname", scanner.nextLine());
    System.out.println();

    System.out.print("Nachname: ");
    newContactInformations.put("name", scanner.nextLine());
    System.out.println();

    System.out.print("Telefon: ");
    newContactInformations.put("phoneNumber", scanner.nextLine());
    System.out.println();

    System.out.print("eMail: ");
    newContactInformations.put("eMail", scanner.nextLine());
    System.out.println();

    System.out.print("Strasse: ");
    newContactInformations.put("street", scanner.nextLine());
    System.out.println();

    System.out.print("PLZ: ");
    newContactInformations.put("zip", scanner.nextLine());
    System.out.println();

    System.out.print("Stadt: ");
    newContactInformations.put("city", scanner.nextLine());
    System.out.println();

    if (!askForComfirmation()) {
      newContactInformations.clear();
    }
    return newContactInformations;
  }

  private boolean askForComfirmation() {
    System.out.println("[S] Aenderung speichern ");
    System.out.println("[A] Abbrechen? ");

    char input = getCharacterCommand();

    switch (input) {
      case 'a':
        return false;
      case 's':
        return true;
      default:
        return askForComfirmation();
    }
  }

  private char getCharacterCommand() {
    try {
      return scanner.nextLine().toLowerCase().charAt(0);
    } catch (StringIndexOutOfBoundsException e) {
      System.out.println("please insert a character as command!!!!");
      getCharacterCommand();
    }
    return ' ';
  }

  public int getContactIndex(StateOfManager state) {
    switch (state) {
      case EDIT_CONTACT:
        System.out.print("Welchen Kontakt möchten sie bearbeiten? ");
        break;
      case DELETE_CONTACT:
        System.out.print("Welchen Kontakt möchten sie löschen? ");
    }
    return Integer.valueOf(scanner.nextLine());
  }
}
