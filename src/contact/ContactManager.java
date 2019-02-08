package contact;

import java.util.HashMap;

public class ContactManager {

  HashMap<Integer, ContactCard> contactCardRepo = new HashMap<>();

  private StateOfManager stateOfManager;

  public boolean runContactManager() {
    while (true) {
      switch (stateOfManager) {
        default:
          return false;
      }
    }
  }
}
