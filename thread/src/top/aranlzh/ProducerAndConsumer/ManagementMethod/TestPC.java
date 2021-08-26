package top.aranlzh.ProducerAndConsumer.ManagementMethod;

// 测试：生产者消费者模型 --> 利用缓冲区解决：管程法

// 生产者、消费者、产品、缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            container.push(new Product(i));
            System.out.println("生产了第"+i+"只鸡");
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println("消费了第"+container.pop().id+"只鸡");
        }
    }
}

// 产品
class Product {
    int id;

    public Product(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer {

    // 需要一个容器大小
    Product[] products = new Product[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Product product) {
        // 如果容器满了，就需要等待消费
        if (count==products.length){
            // 通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满，我们就需要继续生产产品
        products[count] = product;
        count++;

        // 可以通知消费者消费了
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Product pop() {
        // 判断能否消费
        if (count==0) {
            // 等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果可以消费
        count--;
        Product product = products[count];

        // 可以通知生产者生产了
        this.notifyAll();

        return product;
    }
}