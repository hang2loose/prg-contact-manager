package contact;

import contact.services.ContactCardService;

enum StateOfManager {
  GET_COMMAND, END, INIT, CREATE_NEW_CONTACT, DELETE_CONTACT, EDIT_CONTACT,
  PRINT_CONTACT_DETAILS, SAVE_REPOSITORY, LOAD_REPOSITORY, NOT_IMPLEMENTET, GET_ALL_CONTACTS
}

public class ContactManager {

  private static ContactManager contactManager = null;

  public static ContactManager getInstance() {

    if (contactManager == null) {
      contactManager = new ContactManager();
    }
    return contactManager;
  }

  private InputHandler inputHandler;
  private ContactCardService contactCardService;

  private ContactManager() {
    inputHandler = new InputHandler();
    contactCardService = ContactCardService.getInstance();
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
          stateOfManager = inputHandler.getInput();
          break;
        case GET_ALL_CONTACTS:
          clear();
          TableManager.printContactsList(contactCardService.getAllCards());
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case CREATE_NEW_CONTACT:
          contactCardService.createNewContact(inputHandler.getNewContactInformations());
          stateOfManager = StateOfManager.GET_ALL_CONTACTS;
          break;
        case DELETE_CONTACT:
          stateOfManager = executeDeleteContact();
          break;
        case EDIT_CONTACT:
          stateOfManager = executeEditContact();
          break;
        case PRINT_CONTACT_DETAILS:
          stateOfManager = executePrintDetails();
          break;
        case NOT_IMPLEMENTET:
          System.out.println("Not Implementet yet");
          stateOfManager = StateOfManager.GET_COMMAND;
        case END:
          System.out.println("Auf Wiedersehen!");
          return;
        default:
          throw new IllegalStateException("Something went terribly wrong SORRY");
      }
    }
  }

  private StateOfManager executeLoadRepo() {
    if (!contactCardService.readData(inputHandler.getNameOfRepository())) {
      System.out.println("Error while loading Repository!");
    }
    return StateOfManager.GET_COMMAND;
  }

  private StateOfManager executeSaveRepo() {
    if (!contactCardService.wirteData(inputHandler.getNameOfRepository())) {
      System.out.println("Error Repo not Saved!!!!!");
    }
    return StateOfManager.GET_COMMAND;
  }

  private StateOfManager executePrintDetails() {
    int index = inputHandler.getContactIndex(StateOfManager.PRINT_CONTACT_DETAILS);

    if (contactCardService.repoContainsIndex(index)) {
      TableManager.printContactCard(contactCardService.getContactCardFromIndex(index));
      return StateOfManager.GET_COMMAND;
    }
    System.out.println("Kontakt nicht gefunden!");
    return StateOfManager.GET_COMMAND;
  }

  private StateOfManager executeDeleteContact() {
    int indexId = inputHandler.getContactIndex(StateOfManager.DELETE_CONTACT);

    if (contactCardService.repoContainsIndex(indexId)) {
      contactCardService.deleteContactByIndex(indexId);
      return StateOfManager.GET_ALL_CONTACTS;
    }
    System.out.println("Kontakt nicht gefunden!");
    return StateOfManager.GET_COMMAND;
  }

  private StateOfManager executeEditContact() {
    int indexId = inputHandler.getContactIndex(StateOfManager.EDIT_CONTACT);

    if (contactCardService.repoContainsIndex(indexId)) {
      contactCardService.editContactById(indexId, inputHandler.getNewContactInformations());
      return StateOfManager.GET_ALL_CONTACTS;
    }
    System.out.println("Index not found!!!!");
    return StateOfManager.GET_COMMAND;
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
}
