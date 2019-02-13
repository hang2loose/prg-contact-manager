package contact;

import static contact.enums.ManagerState.DELETE_CONTACT;
import static contact.enums.ManagerState.EDIT_CONTACT;
import static contact.enums.ManagerState.GET_ALL_CONTACTS;
import static contact.enums.ManagerState.GET_COMMAND;
import static contact.enums.ManagerState.INIT;
import static contact.enums.ManagerState.PRINT_CONTACT_DETAILS;

import contact.enums.ManagerState;
import contact.enums.SortableColums;
import contact.enums.SortingOrder;
import contact.services.ContactCardService;


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

  private ManagerState managerState = INIT;

  public void runContactManager() {
    while (true) {
      switch (managerState) {
        case INIT:
          startMessage();
          executeLoadRepo();
          managerState = GET_COMMAND;
          break;
        case GET_COMMAND:
          managerState = inputHandler.getInput();
          break;
        case GET_ALL_CONTACTS:
          executeSaveRepo();
          clearAndPrintTable();
          managerState = GET_COMMAND;
          break;
        case CREATE_NEW_CONTACT:
          contactCardService.createNewContact(inputHandler.getNewContactInformation());
          managerState = GET_ALL_CONTACTS;
          break;
        case DELETE_CONTACT:
          managerState = executeDeleteContact();
          break;
        case EDIT_CONTACT:
          managerState = executeEditContact();
          break;
        case PRINT_CONTACT_DETAILS:
          managerState = executePrintDetails();
          break;
        case GET_CONTACT_IN_ORDER:
          managerState = executeContactInOrder();
          break;
        case GET_CONTACT_BY_SEARCH_PARAM:
          TableManager.printContactsList(
              contactCardService.getSearchResult(inputHandler.readSearchParameter()));
          managerState = GET_COMMAND;
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

  private ManagerState executeContactInOrder() {
    SortableColums colum = inputHandler.getColumn();
    SortingOrder order = inputHandler.getOrder(colum);
    System.out.println("Ihre sortierten Kontakte: \n");
    TableManager.printContactsList(contactCardService.orderContacts(colum, order));
    return GET_COMMAND;
  }

  private ManagerState executeLoadRepo() {
    if (!contactCardService.readData("contacts")) {
      ContactCardService.getInstance().initRepoWithDummyData();
      executeSaveRepo();
      System.out.println("Repository initialized with Dummy Data");
    }
    return GET_COMMAND;
  }

  private ManagerState executeSaveRepo() {
    if (!contactCardService.writeData("contacts")) {
      System.out.println("Error: Repository was not saved");
    }
    return GET_COMMAND;
  }

  private ManagerState executePrintDetails() {
    clearAndPrintTable();
    int index = inputHandler.getContactIndex(PRINT_CONTACT_DETAILS);

    if (contactCardService.repoContainsIndex(index)) {
      TableManager.printContactCard(contactCardService.getContactCardFromIndex(index));
      return GET_COMMAND;
    }
    System.out.println("Kontakt nicht gefunden!");
    return GET_COMMAND;
  }

  private ManagerState executeDeleteContact() {
    clearAndPrintTable();
    int indexId = inputHandler.getContactIndex(DELETE_CONTACT);

    if (contactCardService.repoContainsIndex(indexId)) {
      contactCardService.deleteContactByIndex(indexId);
      return GET_ALL_CONTACTS;
    }
    System.out.println("Kontakt nicht gefunden!");
    return GET_COMMAND;
  }

  private ManagerState executeEditContact() {
    clearAndPrintTable();
    int indexId = inputHandler.getContactIndex(EDIT_CONTACT);

    if (contactCardService.repoContainsIndex(indexId)) {
      contactCardService.editContactById(indexId, inputHandler.getNewContactInformation());
      return GET_ALL_CONTACTS;
    }
    System.out.println("404: Index not found");
    return GET_COMMAND;
  }

  private void startMessage() {
    System.out.println("########################################################################");
    System.out.println("#                         Contact Manager v1.0                         #");
    System.out.println("########################################################################");
    System.out.println();
  }

  private void clearAndPrintTable() {
    clear();
    TableManager.printContactsList(contactCardService.getAllCards());
  }

  private static void clear() {
    for (int i = 0; i < 8; i++) {
      System.out.println();
    }
  }
}
