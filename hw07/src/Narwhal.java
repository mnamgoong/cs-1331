/**
 * Represents a Narwhal
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Narwhal extends Pet {

    private int hornLength;

    /**
     * Constructs a Narwhal with a given name, age, pain level, and horn length
     * @param name the Narwhal's name
     * @param age the Narwhal's age
     * @param painLevel the Narwhal's pain level
     * @param hornLength the Narwhal's horn length in feet
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }

    /**
     * Constructs a Narwhal with a default name, age, pain level, and horn length
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    @Override
    public void playWith(Pet p) {
        int oldPainLevel = this.getPainLevel();
        if (p instanceof Narwhal) {
            this.setPainLevel(oldPainLevel - 2);
            System.out.println("Who needs dogs and cats when we have each other");
        } else {
            this.setPainLevel(oldPainLevel + 1);
            System.out.println("I live in the ocean so I can’t play with you");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I have a horn that is " + hornLength + " feet long.";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Narwhal) {
            Narwhal n = (Narwhal) o;
            return (super.equals(o) && this.hornLength == n.hornLength);
        }
        return false;
    }

}
