//I worked on the homework assignment alone, using only course materials.

/**
 * Represents a Bender of the elements.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public abstract class Bender {

    protected String name;
    protected int strengthLevel;
    protected int health;

    /**
     * Constructs a Bender with formal parameters.
     * @param name the name of the Bender
     * @param strengthLevel the strength of the Bender
     * @param health the health of the Bender
     */
    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }

    /**
     * Recovers a Bender's health by a specified amount.
     * @param i the amount health is increased by
     */
    public void recover(int i) {
        if (health != 0) {
            health += i;
        }
    }

    /**
     * Attacks a Bender in a way that is unique to each type of bender.
     * @param b the Bender that is being attacked
     */
    public abstract void attack(Bender b);

    @Override
    public boolean equals(Object o) {
        if (this.getClass() == o.getClass()) {
            Bender other = (Bender) o;
            return (this.name.equals(other.getName())
                    && this.strengthLevel == other.getStrengthLevel()
                    && this.health == other.getHealth());
        }
        return false;
    }

    @Override
    public String toString() {
        return "My name is " + name + ". I am a bender. My strength level is " + strengthLevel
                + " and my current health is " + health + ".";
    }

    /**
     * @return the name of the Bender
     */
    public String getName() {
        return name;
    }

    /**
     * @return the strength of the Bender
     */
    public int getStrengthLevel() {
        return strengthLevel;
    }

    /**
     * Sets the strength of the Bender to a specified value.
     * @param strengthLevel the new strength of the Bender
     */
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    /**
     * @return the health of the Bender
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health of the Bender to a specified value.
     * @param health the new health of the Bender
     */
    public void setHealth(int health) {
        this.health = health;
    }

}
