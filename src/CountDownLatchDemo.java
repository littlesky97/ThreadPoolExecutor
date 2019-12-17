import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t离开教室");
                cdl.countDown();
            }, String.valueOf(i)).start();
        }
        cdl.await();
        System.out.println(Thread.currentThread().getName() + "\t班長走");
    }
}
