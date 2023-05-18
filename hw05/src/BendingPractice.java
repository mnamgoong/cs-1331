public class BendingPractice {

    public static void main(String[] args) {

        WaterBender wb1 = new WaterBender("Katara", 80, 100, true);
        WaterBender wb2 = new WaterBender("Mermaid Man");
        FireBender fb1 = new FireBender("Ace", 120, 20);
        FireBender fb2 = new FireBender("Mushu");
        EarthBender eb1 = new EarthBender("Whitebeard", 100, 80, true);

        System.out.println(wb1.toString());
        System.out.println(fb2.toString());
        System.out.println(eb1.toString());

        fb1.attack(wb2);
        eb1.attack(wb2);
        wb1.heal(wb2);
        eb1.buildArmor();
        wb2.attack(fb2);
        Bender[] b = new Bender[2];
        b[0] = eb1;
        b[1] = wb1;
        fb2.flameCircle(b);
        wb1.recover(5);

        System.out.println(wb1.toString());
        System.out.println(fb2.toString());
        System.out.println(eb1.toString());

        System.out.println("EarthBender team: " + EarthBender.getEarthPoints());
        System.out.println("WaterBender team: " + WaterBender.getWaterPoints());
        System.out.println("FireBender team: " + FireBender.getFirePoints());
    }

}
