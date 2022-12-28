package utilities;

public class ReusableMethods {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye);
        } catch (InterruptedException e) {

        }
    }
}
