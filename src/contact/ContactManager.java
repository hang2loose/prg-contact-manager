package contact;

import contact.enums.SortableColums;
import contact.enums.SortingOrder;
import contact.services.ContactCardService;

enum StateOfManager {
  GET_COMMAND, END, INIT, CREATE_NEW_CONTACT, DELETE_CONTACT, EDIT_CONTACT,
  PRINT_CONTACT_DETAILS, SAVE_REPOSITORY, LOAD_REPOSITORY, NOT_IMPLEMENTET, GET_CONTACT_IN_ORDER,
  GET_CONTACT_BY_SEARCH_PARAM, GET_ALL_CONTACTS
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
  }

  private StateOfManager stateOfManager = StateOfManager.INIT;

  public void runContactManager() {
    while (true) {
      switch (stateOfManager) {
        case INIT:
          start();
          executeLoadRepo();
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case GET_COMMAND:
          stateOfManager = inputHandler.getInput();
          break;
        case GET_ALL_CONTACTS:
          clear();
          executeSaveRepo();
          System.out.println("Ihre Kontakte: \n");
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
        case GET_CONTACT_IN_ORDER:
          SortableColums colum = inputHandler.getColum();
          SortingOrder order = inputHandler.getOrder(colum);
          System.out.println("Ihre sortierten Kontakte: \n");
          TableManager.printContactsList(contactCardService.orderContacts(colum, order));
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case GET_CONTACT_BY_SEARCH_PARAM:
          TableManager.printContactsList(
              contactCardService.getSearchResult(inputHandler.readSearchParameter()));
          stateOfManager = StateOfManager.GET_COMMAND;
          break;
        case END:
          System.out.println("Auf Wiedersehen!");
          executeSaveRepo();
          return;
        default:
          throw new IllegalStateException("Something went terribly wrong SORRY");
      }
    }
  }

  private StateOfManager executeLoadRepo() {
    if (!contactCardService.readData("contacts")) {
      ContactCardService.getInstance().initRepoWithDummyData();
      executeSaveRepo();
      System.out.println("Repository initialized with Dummy data");
    }
    return StateOfManager.GET_COMMAND;
  }

  private StateOfManager executeSaveRepo() {
    if (!contactCardService.wirteData("contacts")) {
      System.out.println("Error: Repository was not saved");
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
    System.out.println();
  }

  private static void clear() {
    for (int i = 0; i < 8; i++) {
      System.out.println();
    }
  }
}
