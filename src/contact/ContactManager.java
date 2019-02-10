package contact;

import contact.services.ContactCardService;

enum StateOfManager {
  GET_COMMAND, END, INIT, NOT_IMPLEMENTET_YET, CREATE_NEW_CONTACT, GET_ALL_CONTACTS
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

  public void runContactManager() {
    while (true) {
      switch (stateOfManager) {
        case INIT:
          start();
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case GET_COMMAND:
          stateOfManager = inputHandler.getInput(stateOfManager);
          break;
        case GET_ALL_CONTACTS:
          clear();
          TableManager.firstTableRow();
          contactCardService.printContactWithIndex();
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case CREATE_NEW_CONTACT:
          inputHandler.getNewContactInformations()
              .ifPresent(a -> contactCardService.createNewContact(a));
          TableManager.firstTableRow();
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case NOT_IMPLEMENTET_YET:
          clear();
          System.out.println("This method is not implementet yet!!!!!!!!!!!!!!!!");
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case END:
          System.out.println("Auf Wiedersehen!");
          return;
        default:
          throw new IllegalStateException("Something went terrible Wrong Sorry for that");
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
