/**
 * Represents a EarthBender (a type of Bender) which has control over the element earth.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class EarthBender extends Bender {

    private boolean earthArmor;
    private static int earthPoints;

    /**
     * Constructs an EarthBender with a specified name and default strengthLevel, health, and earthArmor values.
     *
     * @param name the name of the EarthBender
     */
    public EarthBender(String name) {
        this(name, 40, 100, false);
    }

    /**
     * Constructs an EarthBender with specified name, strengthLevel, health, and earthArmor values.
     *
     * @param name          the name of the EarthBender
     * @param strengthLevel the strength of the EarthBender
     * @param health        the health of the EarthBender
     * @param earthArmor    boolean representing whether the EarthBender has armor up
     */
    public EarthBender(String name, int strengthLevel, int health, boolean earthArmor) {
        super(name, strengthLevel, health);
        this.earthArmor = earthArmor;
    }

    /**
     * Attacks a Bender.
     *
     * @param b the Bender that is being attacked
     */
    public void attack(Bender b) {
        if (health > 0) {
            if (!(b instanceof EarthBender)) {
                b.setHealth(b.getHealth() - strengthLevel);
                if (earthArmor) {
                    b.setHealth(b.getHealth() - 20);
                    earthArmor = false;
                }
                if (b.getHealth() < 20) {
                    earthPoints += b.getStrengthLevel();
                }
                if (b.getHealth() <= 0) {
                    b.setHealth(0);
                    b.setStrengthLevel(0);
                }
            }
        }
    }

    /**
     * Builds up earth armor.
     */
    public void buildArmor() {
        earthArmor = true;
    }

    /**
     * @return boolean representing whether the EarthBender has armor up
     */
    public boolean getEarthArmor() {
        return earthArmor;
    }

    /**
     * @return the current points scored by the EarthBender team
     */
    public static int getEarthPoints() {
        return earthPoints;
    }

}