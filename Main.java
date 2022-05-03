/**
 * Name:
 * Objective:
 * Date:
 */

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter table size: ");
        int size = scanner.nextInt();
        System.out.println("Enter initail hash value: ");
        int initialValue = scanner.nextInt();
        System.out.println("Enter has multiplier: ");
        int hashMultiplier = scanner.nextInt();
        System.out.println("Enter relative prime value: ");
        int relativePrime = scanner.nextInt();

        StringHash hashTable = new StringHash(size, initialValue, hashMultiplier, relativePrime);

        //StringHash hashTable = new StringHash(5, 5381, 33, 7);

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
            System.out.println("\n");
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
                    hashTable.contains(data);
                    continue;
                }
                case 2: {
                    System.out.println("String to add: ");
                    String data = scanner.next().trim();
                    hashTable.add(data);
                    continue;
                }
                case 3: {
                    System.out.println("String to remove: ");
                    String data = scanner.next().trim();
                    hashTable.remove(data);
                    continue;
                }
                case 4: hashTable.displayTable();
                        continue;
                case 5: hashTable.resize();
                        continue;
                default : break;

            }
        }
        scanner.close();
    }
}
