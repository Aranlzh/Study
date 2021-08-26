package top.aranlzh.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    private static volatile List<String> SOURCE_LIST = new ArrayList<>();
    private static  List<String> source_list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {


        // Test1 test1 = new Test1();
        // Test2 test2 = new Test2();
        // test1.start();
        // test2.start();

        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100));
        // threadPoolExecutor.submit(test1);
        // threadPoolExecutor.submit(test2);
        //
        new Thread(()->{
            while (true){
                System.out.println("===线程1===");
                System.out.println("size:"+source_list.size());
                if (source_list.size()> 0){
                    String s =source_list.get(source_list.size() - 1);
                    System.out.println(s);
                    source_list.remove(s);
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println("===线程2===");
                System.out.println("size:"+source_list.size());
                if ( source_list.size() == 0){
                    source_list.add(String.valueOf(new Random().nextInt(10)));
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
