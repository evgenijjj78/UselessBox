import java.util.concurrent.atomic.AtomicBoolean;

public class Toy implements Runnable {
    private final AtomicBoolean toggle;
    private final int pause;

    public Toy(AtomicBoolean toggle, int pause) {
        this.toggle = toggle;
        this.pause = pause;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            if (toggle.get()) {
                try {
                    Thread.sleep(pause); //эта пауза между включением тумблера юзером и выключением его игрушкой
                } catch (InterruptedException ignored) {
                }
                toggle.set(false);
                System.out.printf("Игрушка %s выключил тумблер\n", thread.getName());
            }
        }
    }
}
