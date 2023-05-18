/**
 * Represents a generic Pet
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public abstract class Pet {

    private String name;
    private int age;
    private int painLevel;

    /**
     * Constructs a Pet with a given name, age, and pain level
     * @param name the Pet's name
     * @param age the Pet's age ranging from 1-100
     * @param painLevel the Pet's pain level ranging from 1-10
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        if (age < 1) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
            this.age = age;
        }
        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }

    /**
     * An abstract method that represents this Pet playing with another Pet
     * @param p another Pet to play with
     */
    public abstract void playWith(Pet p);

    @Override
    public String toString() {
        return "My name is " + name + " and I am " + age
                + ". On a scale of one to ten my pain level is " + painLevel + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet p = (Pet) o;
            return (this.name.equals(p.name) && (this.age == p.age) && (this.painLevel == p.painLevel));
        }
        return false;
    }

    /**
     * @return the Pet's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the Pet's age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the Pet's pain level
     */
    public int getPainLevel() {
        return painLevel;
    }

    /**
     * Sets this Pet's pain level to a new pain level
     * @param painLevel a new pain level
     */
    public void setPainLevel(int painLevel) {
        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }

}