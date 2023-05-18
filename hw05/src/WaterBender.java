/**
 * Represents a WaterBender (a type of Bender) which has control over the element water.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class WaterBender extends Bender {

    private boolean healer;
    private static int waterPoints;

    /**
     * Constructs a WaterBender with a specified name and default strengthLevel, health, and healer values.
     * @param name the name of the Bender
     */
    public WaterBender(String name) {
        this(name, 40, 80, false);
    }

    /**
     * Constructs a WaterBender with specified name, strengthLevel, health, and healer values.
     * @param name the name of the WaterBender
     * @param strengthLevel the strength of the WaterBender
     * @param health the health of the WaterBender
     * @param healer boolean representing whether the WaterBender is a healer
     */
    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
    }

    /**
     * Attacks a Bender.
     * @param b the Bender that is being attacked
     */
    public void attack(Bender b) {
        if (health > 0) {
            b.setHealth(b.getHealth() - strengthLevel);
            if (b.getHealth() < 20) {
                waterPoints += b.getStrengthLevel();
            }
            if (b.getHealth() <= 0) {
                b.setHealth(0);
                b.setStrengthLevel(0);
            }
        }
    }

    /**
     * Heals a fellow WaterBender.
     * @param wb the WaterBender that is being healed
     */
    public void heal(WaterBender wb) {
        if (healer) {
            wb.setHealth(wb.getHealth() + 20);
            wb.setStrengthLevel(wb.getStrengthLevel() + 20);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WaterBender) {
            WaterBender other = (WaterBender) o;
            return (super.equals(o) && this.healer == other.isHealer());
        }
        return false;
    }

    @Override
    public String toString() {
        String output = super.toString() + " With my waterbending, I can heal others.";
        if (!healer) {
            output = output.replace("can", "cannot");
        }
        return output;
    }

    /**
     * @return boolean representing whether the WaterBender is a healer
     */
    public boolean isHealer() {
        return healer;
    }

    /**
     * @return the current points scored by the WaterBender team
     */
    public static int getWaterPoints() {
        return waterPoints;
    }

}
