package codedifferently;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ShoppingList<String> stringList = new ShoppingList<>("Ayeshia");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Display items");
            System.out.println("3. Quit");

            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    String newItem = scanner.nextLine();
                    stringList.addQuantity(newItem, 1);
                    System.out.println(newItem + " added to the list.");
                    break;
                case 2:
                    System.out.println(stringList.displayItems());
                    break;
                case 3:
                    System.out.println("Closing Shopping List!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid selection. Please enter a number between 1 and 3.");
            }
        }
    }
}