/**
 * Represents a dog who will be eating a treat.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Doggy {

    private String name;
    private String furColor;
    private boolean glow;
    private double height;
    private static int doggyPopulation = 0;
    protected static Treat[] treatPantry = new Treat[5];

    /**
     * Creates a Doggy with default values
     */
    public Doggy() {
        this("Clifford", "Red", false, 105.0);
    }

    /**
     * Creates a Doggy with a given name, fur color, and level of happiness
     * @param name this dog's name
     * @param furColor this dog's fur color
     * @param glow boolean representing if this dog is glowing/happy
     */
    public Doggy(String name, String furColor, boolean glow) {
        this(name, furColor, glow, 105.0);
    }

    /**
     * Creates a Doggy with a given name, fur color, level of happiness, and height
     * @param name this dog's name
     * @param furColor this dog's fur color
     * @param glow boolean representing if this dog is glowing/happy
     * @param height this dog's height
     */
    public Doggy(String name, String furColor, boolean glow, double height) {
        this.name = name;
        this.furColor = furColor;
        this.glow = glow;
        this.height = height;
        doggyPopulation++;
    }

    /**
     * Represents this dog going outside and having fun
     */
    public void goOutside() {
        height += 1.5;
        glow = true;
        System.out.println("I am having way too much fun!");
    }

    /**
     * Adds a treat in the next available treatPantry slot
     * @param t the Treat object being added to treatPantry
     * @return boolean representing if the treat addition was successful
     */
    public static boolean addTreat(Treat t) {
        for (int i = 0; i < treatPantry.length; i++) {
            if (treatPantry[i] == null) {
                treatPantry[i] = t;
                printPantry();
                return true;
            }
        }
        System.out.println("Pantry is full.");
        return false;
    }

    /**
     * Eats (removes) the first available treat that matches the shape indicated
     * @param shape the shape being searched for to be eaten
     * @return the treat that was eaten or null
     */
    public Treat eatTreat(String shape) {
        for (int i = 0; i < treatPantry.length; i++) {
            if (treatPantry[i].getShape() == shape) {
                if (treatPantry[i].getHappy()) {
                    glow = true;
                } else {
                    glow = false;
                }
                double extraHeight = (treatPantry[i].getNutrients() % 10) * 1.5;
                height += extraHeight;
                Treat eatenTreat = treatPantry[i];
                treatPantry[i] = null;
                printPantry();
                return eatenTreat;
            }
        }
        return null;
    }

    /**
     * @return a String representation of this Doggy
     */
    public String toString() {
        if (glow) {
            return "I am the " + furColor + " doggy named " + name + "! I am currently " + height + " inches tall.";
        } else {
            return "Ruff! I am " + furColor + " " + name + "!";
        }
    }

    /**
     * Helper method that prints the treats available in the shared pantry and the total number of nutrients
     */
    private static void printPantry() {
        int totalNutrients = 0;
        String pantry = "Current Pantry: ";
        for (int i = 0; i < treatPantry.length; i++) {
            if (treatPantry[i] != null) {
                pantry += treatPantry[i].getBrand();
                if ((i != 4) && (treatPantry[i + 1] != null)) {
                    pantry += ", ";
                }
                totalNutrients += treatPantry[i].getNutrients();
            }
        }
        System.out.println(pantry);
        System.out.println("Total Nutrients: " + totalNutrients);
    }

    /**
     * @return this dog's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return this dog's fur color
     */
    public String getFurColor() {
        return furColor;
    }

    /**
     * Sets furColor to a given fur color
     * @param furColor this dog's new fur color
     */
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    /**
     * @return boolean representing if this dog is glowing/happy
     */
    public boolean getGlow() {
        return glow;
    }

    /**
     * Sets glow to a given boolean value
     * @param glow new boolean representing if this dog is glowing/happy
     */
    public void setGlow(boolean glow) {
        this.glow = glow;
    }

    /**
     * @return this dog's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return an array of Treats representing the treats available in the shared pantry
     */
    public static Treat[] getTreatPantry() {
        return treatPantry;
    }

    /**
     * @return the total number of Doggy objects
     */
    public static int getDoggyPopulation() {
        return doggyPopulation;
    }

}