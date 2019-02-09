package contact;

import contact.model.ContactCard;
import java.util.HashMap;

enum StateOfManager {
  GET_INPUT, GET_COMMAND
}

public class ContactManager {

  private static ContactManager contactManager = null;
  private static InputHandler inputHandler = null;

  private ContactManager() {
  }

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
      inputHandler = new InputHandler();
    }
    return contactManager;
  }

  HashMap<Integer, ContactCard> contactCardRepo = new HashMap<>();

  private StateOfManager stateOfManager = StateOfManager.GET_COMMAND;

  public boolean runContactManager() {
    while (true) {
      switch (stateOfManager) {
        case GET_COMMAND:
          prtintCommands();
          stateOfManager = StateOfManager.GET_INPUT;
          break;
        case GET_INPUT:
          stateOfManager = inputHandler.getInput(stateOfManager);
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
