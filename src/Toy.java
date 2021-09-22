import java.util.concurrent.atomic.AtomicBoolean;

class Toy {
    public int count = 5;
    int i = 0;
    public static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void toy() {
        while (i < count) {
            i++; //atomicBoolean.get());
            if (atomicBoolean.compareAndSet(true, false)) {
                System.out.println(Thread.currentThread().getName() + ": А я Выключил!");
            }
        }
    }

    public void user() {
        while (i < count) {
            i++; //atomicBoolean.get());
            if (atomicBoolean.compareAndSet(false, true)) {
                System.out.println(Thread.currentThread().getName() + ": я Включила");
            }
        }
    }
}