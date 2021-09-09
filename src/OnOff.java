import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OnOff extends Thread {
    private Switch switchon;
    public static boolean tumbler;

    public OnOff(Switch switchon) {
        this.switchon = switchon;
    }

    public OnOff() {

    }

    public void switchOn() {
        int i =0;
       while (i<5) {
           System.out.println("Юзер: тумблер ON");
           i= i +1;
           tumbler = true;
           Thread.currentThread().interrupt();
       }
    }

    public void switchOff() {
        while (true) {
            if (tumbler == true)
            System.out.println("Игрушка: тумблер OFF");
            tumbler = false;
            Thread.currentThread().interrupt();
            // this.interrupt();
        }

    }
}




