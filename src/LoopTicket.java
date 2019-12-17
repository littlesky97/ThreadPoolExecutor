import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopTicket {
    public static void main(String[] args) {
        Ticket tick = new Ticket();
        ExecutorService tpe = Executors.newFixedThreadPool(3);
        try {
            for (int i = 1; i <35 ; i++) {
                tpe.execute(tick::sale);
            }
        }finally {
            tpe.shutdown();
        }
    }
}
class  Ticket{
    Lock lock = new ReentrantLock();
    private int ticket=30;
    public  void sale(){
        lock.lock();
        try {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (ticket--) + "还剩" + ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
        }