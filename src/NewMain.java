import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class NewMain {
    public static void main(String[] args) {
       NewMain newMain = new NewMain();
    }

    ExecutorService service;




    public NewMain(){
            service = Executors.newSingleThreadExecutor();
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i <= 1000; i++) {
                        if(Thread.currentThread().isInterrupted()){
                            return;
                        }
                        System.out.println("Witaj świecie jestem z wątku 1");
                    }
                }
            });



        System.out.println("A ja z wątku głównego");



        service.execute(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 1000; i++) {
                    System.out.println("Witaj świecie jestem z wątku 2");
                }
            }
        });

        service.shutdownNow();



    }
}
