public class Toy implements Runnable {
    private final UselessBox box;
    private final int pause;

    public Toy(UselessBox box) {
        this.box = box;
        this.pause = box.pause;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            if (box.toggle) {
                box.toggle = false;
                System.out.printf("Игрушка %s выключил тумблер\n", thread.getName());
            }
            if (thread.isInterrupted()) break;
            try {
                Thread.sleep(pause);
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Игрушка выключилась");
    }
}
