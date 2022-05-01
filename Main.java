import java.text.NumberFormat.Style;
import java.util.Scanner;
import hash.HashTable;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter table size: ");
        // int size = scanner.nextInt();
        // System.out.println("Enter initail hash value: ");
        // int initialValue = scanner.nextInt();
        // System.out.println("Enter has multiplier: ");
        // int hashMultiplier = scanner.nextInt();
        // System.out.println("Enter relative prime value: ");
        // int relativePrime = scanner.nextInt();

        System.out.println();

        //HashTable table = new HashTable(size, initialValue, hashMultiplier, relativePrime);
        HashTable table = new HashTable(5, 5381, 33, 7);

        // System.out.println("Select one of the followings or Q to Quit...\n");
        // System.out.println("""
        //         1. Search String \n
        //         2. Add String \n
        //         3. Remove String \n
        //         4. Display Table \n
        //         5. Resize Table \n
        //         Q. Quit
        //         """);

        // System.out.println("Choice: ");
        String userInput = "0";
        userInput = userInput.trim();
        while(true){
            System.out.println("""
                1. Search String \n
                2. Add String \n
                3. Remove String \n
                4. Display Table \n
                5. Resize Table \n
                Q. Quit

                Choice: 
                """);

            userInput = scanner.next().trim();  //string
            if(userInput.equals("Q") || userInput.equals("q")){
                System.out.println("Exiting the program...");
                System.exit(0);
            }

            int choice = -1;

            try {
                choice = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Inappropriate input... Exiting the program...");
            }

            if(choice < 1 && choice > 5){
                System.out.println("Please select the appropriate choice. Exiting the program...");
                break;
            }

            switch (choice){
                case 1: {
                    System.out.println("String to search for: ");
                    String data = scanner.next().trim();
                    table.contains(data);
                    continue;
                }
                case 2: {
                    System.out.println("String to add: ");
                    String data = scanner.next().trim();
                    table.add(data);
                    continue;
                }
                case 3: {
                    System.out.println("String to remove: ");
                    String data = scanner.next().trim();
                    table.remove(data);
                    continue;
                }
                case 4: table.displayTable();
                        continue;
                case 5: table.resize();
                        continue;
                default : break;

            }
        }
        scanner.close();
    }
}