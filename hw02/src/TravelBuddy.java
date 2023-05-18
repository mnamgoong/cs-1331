//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.text.DecimalFormat;
public class TravelBuddy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("0.00"); //format to two decimal places
        double totalCost = 0;
        System.out.print("Welcome to Travel Buddy Service! Please enter your name here: ");
        String name = input.nextLine();
        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase(); //proper name formatting
        System.out.println("The Hive - $6.00\nInvention Studio - $7.50\nKlaus - $6.90\nCULC - $3.20\n");
        System.out.println("Where would you like to go, "+name+"? ");
        String destination = input.nextLine();
        switch (destination) {
            case "The Hive":
                totalCost = 6.00;
                break;
            case "Invention Studio":
                totalCost = 7.50;
                break;
            case "Klaus":
                totalCost = 6.90;
                break;
            case "CULC":
                totalCost = 3.20;
                break;
            default:
                System.out.println("\nThat destination is invalid, goodbye!");
                return;
        }
        if (destination.equals("CULC") || destination.equals("Klaus")) {
            System.out.println("\nWould you like to stop by Chick-fil-a on the way? (Yes/No)");
            String chickFilA = input.next();
            if (chickFilA.equals("Yes")) {
                totalCost*=1.5;
            } else if (chickFilA.equals("No")){
                totalCost = totalCost;
            } else {
                return;
            }
        }
        System.out.println("\nYour current total is $" + formatter.format(totalCost));
        System.out.println("Do you have a discount? (Yes/No)");
        if (input.next().equals("Yes")) {
            System.out.println("\nWhat is the discount code?");
            String discountCode = input.next();
            if (discountCode.equals("CS1331")) {
                totalCost = totalCost-(.25*totalCost);
                System.out.println("\nYou have received 25% off your ride!");
            } else if (discountCode.equals("IKNOWTHEOWNER")) {
                System.out.println("\nHow much would you like to take off? ");
                if (input.hasNextDouble()) {
                    double discount = input.nextDouble();
                    totalCost = totalCost-discount;
                    System.out.println("\nTaking off $"+formatter.format(discount)+" from your total...");
                } else {
                    totalCost = totalCost-1.00;
                    System.out.println("\nTaking off $1.00 from your total...");
                }
            } else {
                System.out.println("\nThat discount does not exist! Better luck next time!");
            }
        }
        if (totalCost<0) {
            totalCost = 0.00;
        }
        System.out.println("\nThank you for riding with the Travel Buddy Service, "+name+"! You are now $"+formatter.format(totalCost)+" poorer! We hope you ride with us again! :)");
    }
}