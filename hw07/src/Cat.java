/**
 * Represents a Cat
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Cat extends Pet implements Treatable {

    private boolean hasStripes;

    /**
     * Constructs a Cat with a given name, age, pain level, and stripes
     * @param name the Cat's name
     * @param age the Cat's age
     * @param painLevel the Cat's pain level
     * @param hasStripes whether the Cat has stripes or not
     */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }

    /**
     * Constructs a Cat with a given stripes and a default name, age, and pain level
     * @param hasStripes whether the Cat has stripes or not
     */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }

    @Override
    public void playWith(Pet p) {
        int oldPainLevel = this.getPainLevel();
        if (p instanceof Cat) {
            Cat c = (Cat) p;
            if (this.hasStripes == c.hasStripes) {
                this.setPainLevel(oldPainLevel - 4);
                System.out.println("Meow! I love playing with other cats with the same pattern as me");
            } else {
                this.setPainLevel(oldPainLevel - 2);
                System.out.println("Meow! I like playing with other cats without the same pattern as me");
            }
        } else if (p instanceof Dog) {
            this.setPainLevel(oldPainLevel + 1);
            Dog d = (Dog) p;
            System.out.println("Meow. Go away " + d.getName() + "! I don’t like playing with Dogs!");
        }
    }

    @Override
    public void treat() {
        setPainLevel(getPainLevel() - 1);
    }

    @Override
    public String toString() {
        return super.toString() + " My age in human years is " + Treatable.convertCatToHumanYears(getAge()) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            Cat c = (Cat) o;
            return (super.equals(o) && this.hasStripes == c.hasStripes);
        }
        return false;
    }

    /**
     * @return whether the Cat has stripes or not
     */
    public boolean getHasStripes() {
        return hasStripes;
    }

}
