/**
 * @class VirtualPetProject
 * @author Sonal Sekhda
 * @course ITEC 2140 secton 04
 * @date April 21, 2023
 */
import java.sql.SQLOutput;
import java.util.Scanner;
public class VirtualPetSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Virtual Pet Simulator!");
        System.out.print("Enter your pet's name: ");
        String name = input.nextLine();

        System.out.print("Enter your pet's age: ");
        int age = input.nextInt();
        VirtualPet pet = new VirtualPet(name,age);

        while(!pet.isSick() && !pet.isSad()) {
            pet.printStatus();
            System.out.println("Choose an action:");
            System.out.println("1. Feed");
            System.out.println("2. Drink");
            System.out.println("3. Play");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    pet.feed();
                    System.out.println(pet.getName() + " ate some food.");
                    break;
                case 2:
                    pet.drink();

                    System.out.println(pet.getName() + " drank some water.");

                    break;

                case 3:

                    pet.play();

                    System.out.println(pet.getName() + " played with you.");

                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (pet.isSick()) {
                System.out.println(pet.getName() + " became sick and went to the vet.");
        } else {
                System.out.println(pet.getName() + " became sad and needs some love.");
        }

       input.close();
    }
}


