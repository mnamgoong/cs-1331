//In order to help learn course concepts, I worked on the homework with [no one], discussed homework topics and issues
//with [no one], and/or consulted related material that can be found at
//[https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html (split method)].
import java.util.Scanner;

/**
 * Represents a classroom seating arrangement.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Classroom {

    /**
     * Main method
     * @param args arguments from user input
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] classroom = new String[5][5];
        classroom[0][1] = "Amanda";
        classroom[0][4] = "Karishma";
        classroom[1][0] = "Ignacio";
        classroom[1][2] = "Kelly";
        classroom[2][3] = "Lucas";
        classroom[3][2] = "Shreya";
        classroom[3][4] = "Makiyah";
        classroom[4][1] = "Rita";
        classroom[4][4] = "Gautam";

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                String[] splitArgs = args[i].split(" ");
                String lateStudentName = splitArgs[0];
                int lateStudentRow = Integer.parseInt(splitArgs[1]);
                int lateStudentCol = Integer.parseInt(splitArgs[2]);
                classroom[lateStudentRow][lateStudentCol] = lateStudentName;
            }
        }

        while (true) {
            System.out.println("\nWould you like to find a student? [Y]es or [N]o");
            String findStudentResponse = input.nextLine();
            if (findStudentResponse.equals("N") || findStudentResponse.equals("No")) {
                System.out.println("\nFinal configuration of the classroom:\n");
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        System.out.print("|");
                        if (classroom[row][col] == null) {
                            System.out.print(" ");
                        } else {
                            System.out.print(classroom[row][col]);
                        }
                    }
                    System.out.println("|");
                }
                System.out.println("\nThanks for using our software to track your class!");
                return;
            } else {
                System.out.println("\nPlease provide the name of the student you would like to find.");
                String student = input.nextLine();
                boolean studentFound = false;
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        if (classroom[row][col] != null && classroom[row][col].equals(student)) {
                            studentFound = true;
                            System.out.println("\nWould you like to move the student or indicate that they have left? "
                                    + "[M]ove or [L]eft");
                            String moveStudentResponse = input.nextLine();
                            if (moveStudentResponse.toLowerCase().equals("m")) {
                                System.out.println("\nPlease select a location to move this student to.");
                                while (true) {
                                    if (input.hasNextInt()) {
                                        int moveRow = input.nextInt();
                                        if (input.hasNextInt()) {
                                            int moveCol = input.nextInt();
                                            input.nextLine();
                                            if ((moveRow >= 0 && moveRow <= 4) && (moveCol >= 0 && moveCol <= 4)) {
                                                if (classroom[moveRow][moveCol] != null) {
                                                    System.out.println("\nThis is a valid seat location, but student "
                                                            + classroom[moveRow][moveCol]
                                                            + " is seated there! Please select a different location.");
                                                    continue;
                                                } else {
                                                    classroom[moveRow][moveCol] = classroom[row][col];
                                                    classroom[row][col] = null;
                                                    System.out.println("\n" + classroom[moveRow][moveCol]
                                                            + " has been successfully moved!");
                                                    break;
                                                }
                                            } else {
                                                System.out.println("\nPlease enter a valid location.");
                                                continue;
                                            }
                                        }
                                    } else {
                                        input.nextLine();
                                        System.out.println("\nPlease enter a valid location.");
                                        continue;
                                    }
                                }
                            } else {
                                System.out.println("\nStudent " + classroom[row][col] + ", located at " + row + " "
                                        + col + ", left the classroom!");
                                classroom[row][col] = null;
                                break;
                            }
                        }
                    }
                }
                if (!studentFound) {
                    System.out.println("\nThis student is not in the classroom!");
                    continue;
                }
            }
        }
    }

}