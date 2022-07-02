public class UselessBox {
    volatile boolean toggle;
    final int cyclesNum;
    final int waitingTime;
    final int pause;

    UselessBox(int cyclesNum, int waitingTime, int pause) {
        this.cyclesNum = cyclesNum;
        this.waitingTime = waitingTime;
        this.pause = pause;
    }

    public static void main(String[] args) throws InterruptedException {
        UselessBox box = new UselessBox(5, 500, 10);

        Thread user = new Thread(new User(box));

        user.start();

        Thread toy = new Thread(new Toy(box));

        toy.start();

        user.join();

        while (toy.isAlive()) {
            toy.interrupt();
        }
    }
}
