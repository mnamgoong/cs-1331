/**
 * Represents a Vet clinic that can treat Pet objects
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Vet {

    /**
     * A static method that inspects a Pet by printing out its toString method
     * @param pet the Pet being inspected
     */
    public static void inspectPet(Pet pet) {
        System.out.println(pet.toString());
        if (pet instanceof Dog) {
            Dog d = (Dog) pet;
            d.bark();
        }
    }

    /**
     * A static method that treats a Pet
     * @param pet the Pet being treated
     */
    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println("Welcome to the vet " + pet.getName());
            if (pet instanceof Dog) {
                System.out.println("Wow what a cute dog!");
                Dog d = (Dog) pet;
                d.treat();
                giveDogTreat(d);
            } else {
                Cat c = (Cat) pet;
                c.treat();
            }
        } else {
            System.out.println("Sorry, we cannot treat " + pet.getName());
        }
    }

    /**
     * A static method that represents a Dog being given a treat
     * @param dog the Dog being given a treat
     */
    public static void giveDogTreat(Dog dog) {
        dog.setPainLevel(dog.getPainLevel() - 2);
    }

}
