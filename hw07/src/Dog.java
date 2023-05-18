/**
 * Represents a Dog
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Dog extends Pet implements Treatable {

    private String breed;

    /**
     * Constructs a Dog with a given name, age, pain level, and breed
     * @param name the Dog's name
     * @param age the Dog's age
     * @param painLevel the Dog's pain level
     * @param breed the Dog's breed
     */
    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }

    /**
     * Constructs a Dog with a given breed and a default name, age, and pain level
     * @param breed the Dog's breed
     */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }

    @Override
    public void playWith(Pet p) {
        int oldPainLevel = this.getPainLevel();
        if (p instanceof Dog) {
            this.setPainLevel(oldPainLevel - 3);
            System.out.println("Woof! I love playing with other dogs so much that my pain level went from "
                                + oldPainLevel + " to " + this.getPainLevel());
        } else if (p instanceof Cat) {
            Cat c = (Cat) p;
            if (c.getHasStripes()) {
                this.setPainLevel(oldPainLevel + 2);
                System.out.println("AHHH! I thought you were a tiger!");
            } else {
                this.setPainLevel(oldPainLevel - 1);
                System.out.println("Woof. Cats without stripes are okay since they made my pain level go from "
                                    + oldPainLevel + " to " + this.getPainLevel());
            }
        }
    }

    @Override
    public void treat() {
        setPainLevel(getPainLevel() - 3);
    }

    /**
     * Makes the Dog bark
     */
    public void bark() {
        System.out.println("bark bark");
    }

    @Override
    public String toString() {
        return "My name is " + getName() + ", I am " + getAge() + ", and I am a " + breed
                + ". On a scale of one to ten my pain level is " + getPainLevel()
                + ". My age in human years is " + Treatable.convertDogToHumanYears(getAge()) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog d = (Dog) o;
            return (super.equals(o) && this.breed.equals(d.breed));
        }
        return false;
    }

}
