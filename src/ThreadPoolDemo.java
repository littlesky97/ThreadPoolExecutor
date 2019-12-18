import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService tpe = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 0; i <10 ; i++) {
                tpe.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 哈哈哈");
                });
            }
        } finally {
            tpe.shutdown();
        }
    }
}
