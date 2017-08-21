import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class Task2 {
    public static void main(String[] args) {
        new Task2();
    }

    double cash = 0;
    ExecutorService service;
    public Task2() {
        service = Executors.newCachedThreadPool();
        start();
    }

    private void start() {
        // Kilka wpłat
        for(int i = 0; i <= 1234; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    addCash();
                    System.out.println("Kasa po wpłacie: " + cash);

                }
            });
        }
        for(int i = 0; i <= 5; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    multiplyCash();
                    System.out.println("Kasa po kapitalizacji: " + cash);

                }
            });
        }
        for(int i = 0; i <= 999; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    withdrawCash();
                    System.out.println("Kasa po wypłacie: " + cash);
                }
            });
        }
    }


    private void addCash(){
        cash += 132.23;
    }

    private void withdrawCash(){
        cash -= 23.50;
    }

    private void multiplyCash() {
        cash  = cash * 0.02 + cash;
    }

}
