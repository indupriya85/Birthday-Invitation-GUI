import java.util.Scanner;

public class BirthdayInvitation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("        BIRTHDAY INVITATION GENERATOR");
        System.out.println("==========================================");

        System.out.print("Enter birthday person's name: ");
        String name = sc.nextLine();

        System.out.print("Enter birthday date: ");
        String date = sc.nextLine();

        System.out.print("Enter time: ");
        String time = sc.nextLine();

        System.out.print("Enter venue: ");
        String venue = sc.nextLine();

        System.out.print("Enter a short message: ");
        String message = sc.nextLine();

        System.out.println("\n\n--------------- INVITATION ---------------");
        System.out.println("           YOU ARE INVITED!");
        System.out.println();
        System.out.println("Come and celebrate the birthday of");
        System.out.println("              " + name);
        System.out.println();
        System.out.println("Date    : " + date);
        System.out.println("Time    : " + time);
        System.out.println("Venue   : " + venue);
        System.out.println();
        System.out.println(message);
        System.out.println();
        System.out.println("We look forward to celebrating with you!");
        System.out.println("-------------------------------------------");

        sc.close();
    }
}
