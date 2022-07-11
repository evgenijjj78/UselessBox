import java.util.concurrent.atomic.AtomicBoolean;

public class UselessBox {
    static final AtomicBoolean toggle = new AtomicBoolean(false);//ссылочная переменная атомик передается игрушке, что не так?
    static final int cyclesNum = 5; // приватность тут необязательна, переменная статическая, потому что я не создаю объект главного класса.
    static final int pause = 1000; // приватность тут необязательна, переменная статическая, потому что я не создаю объект главного класса.

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
