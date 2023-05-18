//I worked on the homework assignment alone, using only course materials.

/**
 * A driver class for the classes Doggy and Treat
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class LunchTime {

    /**
     * Main method
     * @param args arguments from user input
     */
    public static void main(String[] args) {
        Doggy dog1 = new Doggy();
        Doggy dog2 = new Doggy("Sideways", "Gray", false);
        Doggy dog3 = new Doggy("Spot", "Black", true, 50.5);
        Doggy dog4 = new Doggy("Luna", "Brown", true, 175.8);

        Treat treat1 = new Treat();
        Treat treat2 = new Treat("MilkBoolean", 8);
        Treat treat3 = new Treat("Puperoni Bytes", "Circle", 2, true);
        Treat treat4 = new Treat("Ducky Snacks", "Square", 0, false);

        System.out.println(Doggy.getDoggyPopulation());
        Doggy.addTreat(treat1);
        Doggy.addTreat(treat2);
        Doggy.addTreat(treat3);
        Doggy.addTreat(treat4);

        dog2.goOutside();
        dog3.eatTreat("Circle");
        treat4.birthday(dog1);
        treat1.puppucino(dog4);

        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());
        System.out.println(dog4.toString());
        System.out.println(treat1.toString());
        System.out.println(treat2.toString());
        System.out.println(treat3.toString());
        System.out.println(treat4.toString());

    }
}