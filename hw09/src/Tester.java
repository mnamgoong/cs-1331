public class Tester {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        //Fill linked list with letters A-P
        for (int i = 0; i < 16; i++) {
            ll.addAtIndex("" + (char) (i + 65), i);
        }
        //Print list
        System.out.println(ll.toArrayList());
        //Remove A
        System.out.println(ll.removeFromIndex(0));
        System.out.println(ll.toArrayList());
        //Add Q to the end
        ll.addAtIndex("Q", 15);
        System.out.println(ll.toArrayList());
        //Remove Q
        ll.removeFromIndex(15);
        System.out.println(ll.toArrayList());
        //Get B, print
        System.out.println(ll.get(0));
        //Get P, print
        System.out.println(ll.get(14));
            //NEW
        System.out.println(ll.toArrayList().size());
        try {
            System.out.println(ll.get(20));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(ll.toArrayList());
        System.out.println(ll.get(5));
        System.out.println(ll.removeFromIndex(5));
        System.out.println(ll.toArrayList());
        ll.addAtIndex("Z", 3);
        System.out.println(ll.toArrayList());
            //NEW - look at above
        //Get fizzBuzzLinkedList and print
        System.out.println(ll.fizzBuzzLinkedList().toArrayList());
        //Print isEmpty (false)
        System.out.println(ll.isEmpty());
        //clear
        ll.clear();
        //Print isEmpty (true)
        System.out.println(ll.isEmpty());
        //Throw IllegalArgumentExeption since index is out of range [0, size] inclusive
        try {
            ll.addAtIndex("This is gonna throw an exception", 1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //Throw NoSuchElementException since linked list is already cleared
        try {
            ll.clear();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
            //NEW - try to remove
        try {
            ll.removeFromIndex(0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
