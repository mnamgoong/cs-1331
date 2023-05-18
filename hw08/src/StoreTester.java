import java.io.File;

/**
 * @author 
 * @version 1.0
 */
public class StoreTester {
    /**
     * Tester for Store class
     * @param args cli args
     */
    public static void main(String[] args)  {
        File f = new File("store_inventory.csv");
        File thanksgiving = new File("thanksgiving.csv");
        File halloween = new File("halloween.csv");
        String receipt = "receipt.csv";
        Store s1 = new Store(f);
        try {
            s1.goShopping(halloween, receipt);
        } catch (InvalidFormatException e) {
            System.out.println(e);
        }

        // Expected Results
        // goShopping(halloween, receipt)
        //   -> receipt.csv should be
        //        Jack O Lantern,0
        //        Pumpkin,11
        //        TOTAL,11
        // goShopping(thanksgiving, receipt)
        //   -> receipt.csv should be
        //        Turkey,13
        //        Mac and cheese,6
        //        TOTAL,19
    }
}
