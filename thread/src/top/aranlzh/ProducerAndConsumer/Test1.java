package top.aranlzh.ProducerAndConsumer;

public class Test1 extends Thread {

    @Override
    public void run() {
        try{
            while (true){
                try{
                    System.out.println("===线程1===");
                    System.out.println("size:"+MyList.list.size());
                    if (MyList.list.size()> 0){
                        String s = MyList.list.get(MyList.list.size() - 1);
                        System.out.println("准备移除"+s+"，list：");
                        MyList.list.stream().forEach( item -> System.out.print(item));
                        System.out.println();
                        MyList.list.remove(s);
                        System.out.println("移除成功："+s);
                    }
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
