/**
 * Created by Lenovo on 18.08.2017.
 */
public class Main {
    public static void main(String[] args) {


        new Thread(new NumberTask(1, 1000)).start();
        new Thread(new NumberTask(1001, 10000)).start();
        new Thread(new NumberTask(100000, 100000000)).start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Nie spijcie!");
            }
        }).start();

    }



    private static class NumberTask implements Runnable{

        private int low;
        private int high;

        public NumberTask(int l, int h){
            low = l;
            high = h;
        }
        @Override
        public void run() {
            int sum = 0;
            for(int i = low; i <= high; i++){
                for(int x = 2; x < i; x++ ){
                    if( i % x == 0 ){
                        sum++;
                        break;
                    }
                }
                if(i % 100000 == 0){
                    System.out.println("Nowy próg");
                }
            }
            System.out.println("W przedziale od " + low + " do przedzialu " + high + " jest " + (high - low - sum) + " liczb pietwszych");
        }
    }
}
