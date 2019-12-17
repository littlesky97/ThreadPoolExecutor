import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintO {

    public static void main(String[] args) {
        Test test = new Test();
            new Thread(() -> {
                for (int j = 1; j <= 10; j++) {
                    test.print();
                }
            }).start();
    }
}

class Test {
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    public int flag = 1;

    /* public void print5() {
         lock.lock();
         try {
             while (flag != 1) {
                 c1.await();
             }
             for (int i = 1; i <= 5; i++) {
                 System.out.println(Thread.currentThread().getName() + i);
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             flag = 2;
             c2.signal();
         }

     }

     public void print10() {
         lock.lock();
         try {
             while (flag != 2) {
                 c2.await();
             }
             for (int i = 1; i <= 10; i++) {
                 System.out.println(Thread.currentThread().getName() + i);
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             flag = 3;
             c3.signal();
         }

     }

     public void print15() {
         lock.lock();
         try {
             while (flag != 3) {
                 c3.await();
             }
             for (int i = 1; i <= 15; i++) {
                 System.out.println(Thread.currentThread().getName() + i);
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             flag = 1;
             c1.signal();
         }

     }*/
    public void print() {

    }
}