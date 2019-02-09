package contact;

import contact.services.ContactCardService;

enum StateOfManager {
  GET_INPUT, GET_COMMAND, END, INIT, GET_ALL_CONTACTS
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


  private StateOfManager stateOfManager = StateOfManager.INIT;

  public boolean runContactManager() {
    while (true) {
      switch (stateOfManager) {
        case INIT:
          start();
          stateOfManager = StateOfManager.GET_COMMAND;
        case GET_COMMAND:
          stateOfManager = inputHandler.getInput(stateOfManager);
          break;
        case GET_ALL_CONTACTS:
          clear();
          System.out.println(contactCardService.getAllLastNames());
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case END:
        default:
          return false;
      }
    }
  }

  private void start() {
    System.out.println("########################################################################");
    System.out.println("#                         Contact Manager v1.0                         #");
    System.out.println("########################################################################");
  }

  private static void clear() {
    for (int i = 0; i < 8; i++) {
      System.out.println();
    }
  }

  public static ContactManager getInstance() {

    if (contactManager == null) {
      contactManager = new ContactManager();
    }
    return contactManager;
  }
}
