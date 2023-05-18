//I worked on the homework assignment alone, using only course materials.

/**
 * An interface that guarantees an Object is Treatable
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public interface Treatable {

    /**
     * A static method that converts a Dog's age to human years
     * @param dogAge a Dog's age in Dog years
     * @return this Dog's age in human years
     */
    static int convertDogToHumanYears(int dogAge) {
        int humanAge = (int) (16 * Math.log(dogAge) + 31);
        return humanAge;
    }

    /**
     * A static method that converts Cat's age to human years
     * @param catAge a Cat's age in Cat years
     * @return this Dog's age in human years
     */
    static int convertCatToHumanYears(int catAge) {
        int humanAge = (int) (9 * Math.log(catAge) + 18);
        return humanAge;
    }

    /**
     * An abstract method that improves the Object's condition in some way
     */
    void treat();

}