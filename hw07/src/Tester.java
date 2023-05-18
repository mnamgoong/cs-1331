public class Tester {
    public static void main(String[] args) {

        Dog roons = new Dog("Rooney", 3, 8, "labrador");
        Dog dog1 = new Dog("yorkie"); //name: Buzz, age: 6, painLevel: 3
        Dog dog2 = new Dog("Doggo", 3, 8, "labrador");
        Dog dog3 = new Dog("yorkie");
        Cat leo = new Cat("Leo", 3, 9, false);
        Cat cookie = new Cat("Cookie", 4, 9, true);
        Cat cat1 = new Cat(true); //name: Purrfect, age: 4, painLevel: 9
        Cat cat2 = new Cat(false); //name: Purrfect, age: 4, painLevel: 9
        Cat cat3 = new Cat(false);
        Narwhal whale = new Narwhal("Whale", 7, -2, 9);
        Narwhal narwhal1 = new Narwhal(); //name: Jelly, age: 19, painLevel: 2, hornLength: 7
        Narwhal narwhal2 = new Narwhal("Humpback", 4, 1, 10);
        Narwhal narwhal3 = new Narwhal();

        //Testing Treatable
        System.out.println(Treatable.convertDogToHumanYears(3)); //48
        System.out.println(Treatable.convertCatToHumanYears(3)); //27

        //Testing Dog
        roons.playWith(dog1); //painLevel: 8-3 = 5
        //Woof! I love playing with other dogs so much that my pain level went from 8 to 5
        roons.playWith(leo); //painLevel: 5-1 = 4
        //Woof. Cats without stripes are okay since they made my pain level go from 5 to 4
        roons.playWith(cat1); //painLevel: 4+2 = 6
        //AHHH! I thought you were a tiger!
        roons.playWith(narwhal1);
        roons.treat(); //painLevel: 6-3 = 3
        roons.bark();
        //bark bark
        System.out.println(roons.toString());
        //My name is Rooney, I am 3, and I am a labrador. On a scale of one to ten my pain level is 3. My age in human years is 48.
        System.out.println(roons.equals(dog1));
        //false
        System.out.println(dog1.equals(dog3));
        //true

        //Testing Cat
        leo.playWith(cat2); //painLevel: 9-4 = 5
        //Meow! I love playing with other cats with the same pattern as me
        leo.playWith(cat1); //painLevel: 5-2 = 3
        //Meow! I like playing with other cats without the same pattern as me
        leo.playWith(roons); //painLevel: 3+1 = 4
        //Meow. Go away Rooney! I don’t like playing with Dogs!
        leo.playWith(narwhal1);
        leo.treat(); //painLevel: 4-1 = 3
        System.out.println(leo.toString());
        //My name is Leo and I am 3. On a scale of one to ten my pain level is 3. My age in human years is 27.
        System.out.println(leo.equals(cat2));
        //false
        System.out.println(cat2.equals(cat3));
        //true

        //Testing Narwhal
        whale.playWith(roons); //painLevel: 1+1 = 2
        //I live in the ocean so I can’t play with you
        whale.playWith(cookie); //painLevel: 2+1 = 3
        //I live in the ocean so I can’t play with you
        whale.playWith(narwhal1); //painLevel: 3-2 = 1
        //Who needs dogs and cats when we have each other
        narwhal2.playWith(narwhal1); //painLevel: 1-2 = -1 but should be 1
        //Who needs dogs and cats when we have each other
        System.out.println(whale.toString());
        //My name is Whale and I am 7. On a scale of one to ten my pain level is 1. I have a horn that is 9 feet long.
        System.out.println(narwhal2.toString());
        //My name is Humpback and I am 4. On a scale of one to ten my pain level is 1. I have a horn that is 10 feet long.
        System.out.println(narwhal1.equals(narwhal3));
        //true
        System.out.println(narwhal1.equals(narwhal2));
        //false

        //Testing Vet
        Vet.inspectPet(narwhal2);
        //My name is Humpback and I am 4. On a scale of one to ten my pain level is 1. I have a horn that is 10 feet long.
        System.out.println(narwhal2.toString());
        //My name is Humpback and I am 4. On a scale of one to ten my pain level is 1. I have a horn that is 10 feet long.
        Vet.inspectPet(roons);
        //My name is Rooney, I am 3, and I am a labrador. On a scale of one to ten my pain level is 3. My age in human years is 48.
        //bark bark
        System.out.println(roons.toString());
        //My name is Rooney, I am 3, and I am a labrador. On a scale of one to ten my pain level is 3. My age in human years is 48.
        Vet.inspectPet(whale);
        //My name is Whale and I am 7. On a scale of one to ten my pain level is 1. I have a horn that is 9 feet long.
        Vet.treatPet(narwhal1);
        //Sorry, we cannot treat Jelly
        Vet.treatPet(leo); //painLevel: 3-1 = 2
        //Welcome to the vet Leo
        System.out.println(leo.toString());
        //My name is Leo and I am 3. On a scale of one to ten my pain level is 2. My age in human years is 27.
        Vet.treatPet(dog2); //8-3 = 5 and then 5-2 = 3
        //Welcome to the vet Doggo
        //Wow what a cute dog!
        System.out.println(dog2.toString());
        //My name is Doggo, I am 3, and I am a labrador. On a scale of one to ten my pain level is 3. My age in human years is 48.

    }
}
