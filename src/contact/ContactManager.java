package contact;

import java.util.HashMap;

enum StateOfManager {
  GET_COMMAND
}

public class ContactManager {

  private static ContactManager contactManager = null;

  public static ContactManager getInstance() {

    if (contactManager == null) {
      System.out
          .println("########################################################################");
      System.out
          .println("#                         Contact Manager v1.0                         #");
      System.out
          .println("########################################################################");
      System.out.println("\n");
      contactManager = new ContactManager();
    }
    return contactManager;
  }

  HashMap<Integer, ContactCard> contactCardRepo = new HashMap<>();

  private static StateOfManager stateOfManager = StateOfManager.GET_COMMAND;

  public static boolean runContactManager() {
    while (true) {
      switch (stateOfManager) {
        case GET_COMMAND:
          prtintCommands();
          clear();
          break;
        default:
          return false;
      }
    }
  }

  private static void prtintCommands() {
    System.out.println("[A] Alle Kontakte anzeigen");
    System.out.println("[N] Neuen Kontakt erstellen");
    System.out.println("[K] Kontakt bearbeiten");
    System.out.println("[D] Kontaktdetails erstellen");
    System.out.println("[L] Kontakt loeschen");
    System.out.println("[B] Beenden");
  }

  private static void clear() {
    for (int i = 0; i < 5; i++) {
      System.out.println();
    }
  }
}
