package contact;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputHandler {

  private Scanner scanner = new Scanner(System.in);

  StateOfManager getInput(StateOfManager state) {
    prtintCommands();

    System.out.print(">");

    // TODO throw exception if string is longer than 1;
    char command = scanner.nextLine().toLowerCase().charAt(0);

    switch (command) {
      case 'a':
        return StateOfManager.GET_ALL_CONTACTS;
      case 'n':
        return StateOfManager.NOT_IMPLEMENTET_YET;
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
