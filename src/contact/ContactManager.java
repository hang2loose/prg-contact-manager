package contact;

import java.util.HashMap;

enum StateOfManager {
}

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
