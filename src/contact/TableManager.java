package contact;

class TableManager {

  private TableManager() {
  }

  static void firstTableRow() {
    System.out.printf("%19s%16s%26s%29s%n", "Surname", "Name", "Phone", "Mail");
    for (int i = 0; i < 90; i++) {
      System.out.print("-");
    }
    System.out.println();
  }
}
