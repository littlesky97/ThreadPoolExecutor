import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotify {

    public static void main(String[] args) {
        AirConditioner a = new AirConditioner();
        new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                a.add();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                a.jian();
            }
        }, "B").start();
    }
}

class AirConditioner {
    Lock lock = new ReentrantLock();
    Condition c = lock.newCondition();
    private int num = 0;

    public void add() {
        lock.lock();
        try {
            while (num != 0) {
                c.await();
            }
            ++num;
            System.out.println(Thread.currentThread().getName() + num);
            c.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void jian() {
        lock.lock();
        try {
            while (num != 1) {
                c.await();
            }
            --num;
            System.out.println(Thread.currentThread().getName() + num);
            c.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}