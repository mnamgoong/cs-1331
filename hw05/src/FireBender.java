/**
 * Represents a FireBender (a type of Bender) which has control over the element fire.
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class FireBender extends Bender {

    private static int firePoints;

    /**
     * Constructs a FireBender with a specified name and default strengthLevel and health values.
     * @param name the name of the FireBender
     */
    public FireBender(String name) {
        this(name, 60, 50);
    }

    /**
     * Constructs a FireBender with specified name, strengthLevel, and health values.
     * @param name the name of the FireBender
     * @param strengthLevel the strength of the FireBender
     * @param health the health of the FireBender
     */
    public FireBender(String name, int strengthLevel, int health) {
        super(name, strengthLevel, health);
    }

    /**
     * Attacks a Bender.
     * @param b the Bender that is being attacked
     */
    public void attack(Bender b) {
        if (health > 5) {
            b.setHealth(b.getHealth() - strengthLevel);
            if (b.getHealth() < 20) {
                firePoints += b.getStrengthLevel();
            }
            if (b.getHealth() <= 0) {
                b.setHealth(0);
                b.setStrengthLevel(0);
            }
        }
    }

    /**
     * Attacks multiple Benders through a wide attack.
     * @param b an array of Benders that are being attacked
     */
    public void flameCircle(Bender[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i].setHealth(b[i].getHealth() - 10);
            if (b[i].getHealth() < 0) {
                b[i].setHealth(0);
            }
            firePoints += 5;
        }
    }

    /**
     * @return the current points scored by the FireBender team
     */
    public static int getFirePoints() {
        return firePoints;
    }

}
