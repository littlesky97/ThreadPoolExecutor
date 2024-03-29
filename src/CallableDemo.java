import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       FutureTask futureTask=new FutureTask(new Mythread());
       new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }
}
class Mythread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("*****come in call ");
        return "ok";
    }
}