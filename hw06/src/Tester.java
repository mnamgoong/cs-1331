public class Tester {

    public static void main (String[] args) {

        LibraryItem bookOne = new Book("Item One", 8, "A book that's good", 10);
        LibraryItem bookTwo = new Book("Item Two", 5, "A book that's good", 10);
        System.out.println(bookOne.compareTo(bookTwo));

        LibraryItem magOne = new Magazine("Mag One", 6, "A magazine that's good");

        LibraryItem[] bookshelf = {bookOne, bookTwo};
        Library lib = new Library(bookshelf);
        lib.addLibraryItem(magOne);

        lib.browseLibraryItems();
        System.out.println(lib.getLibraryItem(8));
        System.out.println(lib.getNumberOfItems());

    }

}
