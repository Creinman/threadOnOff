/*public class User extends Thread {
    Toy toy = new Toy();
    Object toyq = new Object();
    int severalTimes = 5;
    int i = 0;

    @Override
    public synchronized void run() {

            while (i < severalTimes) {
                i = i + 1;
                System.out.println("Пользователь: тумблер ON");
                toy.tumbler = true;
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
*/