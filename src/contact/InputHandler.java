package contact;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

class InputHandler {

  private Scanner scanner = new Scanner(System.in);

  StateOfManager getInput(StateOfManager state) {
    prtintCommands();

    System.out.print("> ");

    //TODO throw exception if string is longer than 1;
    char command = scanner.nextLine().toLowerCase().charAt(0);

    switch (command) {
      case 'a':
        return StateOfManager.GET_ALL_CONTACTS;
      case 'n':
        return StateOfManager.CREATE_NEW_CONTACT;
      case 'k':
        return StateOfManager.NOT_IMPLEMENTET_YET;
      case 'd':
        return StateOfManager.NOT_IMPLEMENTET_YET;
      case 'l':
        return StateOfManager.NOT_IMPLEMENTET_YET;
      case 'b':
        return StateOfManager.NOT_IMPLEMENTET_YET;
      default:
        throw new InputMismatchException("The givin imput [" + command + "] is not a command");
    }
  }

  public Optional<HashMap<String, String>> getNewContactInformations() {
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

    Optional<Boolean> input = askForComfirmation();
    while (!input.isPresent()) {
      System.out.println("Wrong input");
      input = askForComfirmation();
    }
    return input.get() ? Optional.of(newContactInformations) : Optional.empty();
  }

  private Optional<Boolean> askForComfirmation() {
    System.out.println("[S] Aenderung speichern ");
    System.out.println("[A] Abbrechen? ");

    char input = scanner.nextLine().toLowerCase().charAt(0);

    switch (input) {
      case 'a':
        return Optional.of(false);
      case 's':
        return Optional.of(true);
      default:
        return Optional.empty();
    }
  }

  private static void prtintCommands() {
    System.out.println("\n\n");
    System.out.println("[A] Alle Kontakte anzeigen");
    System.out.println("[N] Neuen Kontakt erstellen");
    System.out.println("[K] Kontakt bearbeiten");
    System.out.println("[D] Kontaktdetails erstellen");
    System.out.println("[L] Kontakt loeschen");
    System.out.println("[B] Beenden");
  }
}
