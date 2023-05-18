public class StringOperations {
    public static void main(String[] args) {
        String myName = "Michelle Namgoong";
        System.out.println(myName);
        myName = myName.replace('M', 'A');
        myName = myName.replace('g', 'Z');
        System.out.println(myName);
        String webAddress = "www.gatech.edu";
        System.out.println(webAddress);
        String newWebAddress = webAddress.substring(4, 10) + 1331;
        System.out.println(newWebAddress);
    }
}
