import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritrDemo {

    public static void main(String[] args) {
        MyCahe myCahe = new MyCahe();
        for (int i = 1; i <= 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                myCahe.put(tempI + "", "哈哈哈哈哈");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                myCahe.get(tempI + "");
            }, String.valueOf(i)).start();
        }
    }

}

class MyCahe {
    private volatile Map<String, String> map = new HashMap<>();
    ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入结束");

        } finally {
            rwl.writeLock().unlock();
        }
    }

    public void get(String key) {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 读取开始");
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结束" + result);
        } finally {
            rwl.readLock().unlock();
        }
    }
}
