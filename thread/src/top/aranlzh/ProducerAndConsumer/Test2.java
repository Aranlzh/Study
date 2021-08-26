package top.aranlzh.ProducerAndConsumer;

import java.util.Random;

public class Test2 extends  Thread{

    @Override
    public void run() {
        try{
            while (true){
                System.out.println("===线程2===");
                System.out.println("size:"+MyList.list.size());
                if ( MyList.list.size() == 0){
                    MyList.list.add(String.valueOf(new Random().nextInt(10)));
                }
                Thread.sleep(2000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}