import java.util.concurrent.atomic.AtomicBoolean;

public class UselessBox {
    static AtomicBoolean toggle = new AtomicBoolean(false);
    static final int cyclesNum = 5;
    static final int pause = 1000;

    public static void main(String[] args) throws InterruptedException {

        Thread user = new Thread(new User(toggle, cyclesNum, pause));

        user.start();

        Thread toy = new Thread(new Toy(toggle, pause));

        toy.setDaemon(true);

        toy.start();

        user.join();

        Thread.sleep(pause);

        System.out.println("Игра завершилась");
    }
}
