import java.util.concurrent.atomic.AtomicBoolean;

public class User implements Runnable {

    private final AtomicBoolean toggle;
    private final int cyclesNum;
    private final int pause;

    public User(AtomicBoolean toggle, int cyclesNum, int pause) {
        this.toggle = toggle;
        this.cyclesNum = cyclesNum;
        this.pause = pause;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int i = 0;
        while (i < cyclesNum) {
            if (!toggle.get()) {
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException ignored) {
                }
                toggle.set(true);
                System.out.printf("Пользователь %s включил тумблер\n", name);
                i++;
            }
        }
        System.out.println("Пользователь закончил игру");
    }
}
