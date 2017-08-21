import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class Task1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
    }

    ExecutorService executorService;
    private int counter;

    public Task1()  {
        executorService = Executors.newCachedThreadPool();
        start();
    }

    public void start() {
        for(int i = 2; i <= 1000; i++) {
            executorService.execute(new TaskFirstNumber(i));
        }
    }

    public synchronized void incrementCounter(){
        counter++;
    }

    private class TaskFirstNumber implements Runnable{
        private int number;

        public TaskFirstNumber(int number) {
            this.number = number;
        }
        @Override
        public void run() {
            boolean increment = true;
            for(int i = 2; i < number; i++){
                if(number % i == 0 ){
                    increment = false;
                }
            }
            if(increment){
                incrementCounter();
            }
            System.out.println(counter);
        }
    }
}
