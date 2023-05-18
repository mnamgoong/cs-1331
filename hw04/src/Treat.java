/**
 * Represents a treat that a dog will eat.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Treat {

    private String brand;
    private String shape;
    private int nutrients;
    private boolean happy;

    /**
     * Creates a Treat with default values
     */
    public Treat() {
        this("Bits & Bytes", "Circle", 10, false);
    }

    /**
     * Creates a Treat with a given brand and number of nutrients
     * @param brand this treat's brand name
     * @param nutrients this treat's number of nutrients
     */
    public Treat(String brand, int nutrients) {
        this(brand, "Circle", nutrients, false);
    }

    /**
     * Creates a Treat with a given brand, shape, number of nutrients, and factor of happiness
     * @param brand this treat's brand name
     * @param shape this treat's shape
     * @param nutrients this treat's number of nutrients
     * @param happy boolean representing if this treat makes dogs happy
     */
    public Treat(String brand, String shape, int nutrients, boolean happy) {
        this.brand = brand;
        this.shape = shape;
        this.nutrients = nutrients;
        this.happy = happy;
    }

    /**
     * Determines whether or not a dog should get a puppucino based on the number of nutrients in a treat
     * and prints a respective statement
     * @param dog the Dog object on which this method is being invoked on
     */
    public void puppucino(Doggy dog) {
        if (nutrients < 5) {
            System.out.println("Let us go to Starbucks, " + dog.getName());
        } else {
            System.out.println(dog.getName() + ", the " + brand + " treat is good for you.");
            dog.setGlow(false);
        }
    }

    /**
     * Determines whether or not it's a dog's birthday based on its height
     * and prints a respective statement
     * @param dog the Dog object on which this method is being invoked on
     */
    public void birthday(Doggy dog) {
        if ((dog.getHeight() >= 48) && dog.getGlow()) {
            System.out.println("Happy birthday, " + dog.getName() + "!");
            dog.setFurColor("Glittery purple");
        } else if (dog.getHeight() < 48) {
            System.out.println(dog.getName() + " is still a Puppy.");
        } else {
            System.out.println("Today is not your birthday, " + dog.getName() + ".");
        }
    }

    /**
     * @return a String representation of this treat
     */
    public String toString() {
        if (happy) {
            return "I am a " + brand + " dog treat in the shape of a " + shape
                    + " with " + nutrients + " nutrients. I make dogs happier!";
        } else {
            return "I am a " + brand + " dog treat in the shape of a " + shape
                    + " with " + nutrients + " nutrients.";
        }
    }

    /**
     * @return this treat's brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return this treat's shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @return this treat's number of nutrients
     */
    public int getNutrients() {
        return nutrients;
    }

    /**
     * @return boolean representing if this treat makes dogs happy
     */
    public boolean getHappy() {
        return happy;
    }

}