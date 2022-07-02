public class User implements Runnable {
    private final UselessBox box;
    private final int cyclesNum;
    private final int waitingTime;

    public User(UselessBox box) {
        this.box = box;
        this.cyclesNum = box.cyclesNum;
        this.waitingTime = box.waitingTime;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int i = 0;
        while (i < cyclesNum) {
            if (!box.toggle) {
                box.toggle = true;
                System.out.printf("Пользователь %s включил тумблер\n", name);
                i++;
            }
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Пользователь закончил игру");
    }
}
