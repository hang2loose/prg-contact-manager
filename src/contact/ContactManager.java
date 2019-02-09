package contact;

import contact.services.ContactCardService;

enum StateOfManager {
  GET_INPUT, GET_COMMAND, END, GET_ALL_CONTACTS
}

public class ContactManager {

  private static ContactManager contactManager = null;

  private InputHandler inputHandler;
  private ContactCardService contactCardService;

  private ContactManager() {
    inputHandler = new InputHandler();
    contactCardService = new ContactCardService();
    contactCardService.initRepoWithDummyData();
  }


  private StateOfManager stateOfManager = StateOfManager.GET_COMMAND;

  public boolean runContactManager() {
    while (true) {
      switch (stateOfManager) {
        case GET_COMMAND:
          stateOfManager = StateOfManager.GET_INPUT;
          break;
        case GET_INPUT:
          stateOfManager = inputHandler.getInput(stateOfManager);
          break;
        case GET_ALL_CONTACTS:
          System.out.println(contactCardService.getAllLastNames());
          stateOfManager = StateOfManager.GET_INPUT;
          break;
        case END:
        default:
          return false;
      }
    }
  }

  private static void clear() {
    for (int i = 0; i < 5; i++) {
      System.out.println();
    }
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
    }
    return contactManager;
  }
}
