

/*public class Toy extends Thread {
    public static boolean tumbler;
    int severalTimes = 5;
    int i = 0;

    public void toy() {
        synchronized (user) {
            while (i < severalTimes) {
                i = i + 1;
                // if (!tumbler) {
                System.out.println("Игрушка: тумблер OFF");
                tumbler = false;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void user() {

        while (i < severalTimes) {
            i = i + 1;
            System.out.println("Пользователь: тумблер ON");
            tumbler = true;
            try {
                notify();
                //Thread.sleep(3000);
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//}
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.locks.Condition.*;

class Toy extends ReentrantLock {
    Lock lock = new ReentrantLock();
    Condition condition = newCondition();
    public void user() {
        try {
            lock.lock();
            Thread.sleep(3000);
            System.out.println("Пользователь включил");
            condition.signal(); // Вместо notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void toy() {
        int i = 0;
        try {
            lock.lock();
        //    while (i<5) {
                i = i + 1;
                System.out.println("Игрушка выключила");
                condition.await(); // Вместо wait();
           // }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}