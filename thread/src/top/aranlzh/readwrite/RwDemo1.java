package top.aranlzh.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

//演示读写锁降级
public class RwDemo1 {

    public static void main(String[] args) {
        //可重入读写锁对象
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();//读锁
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();//写锁

        //锁降级（写->读）可以，升级（读->写）不可

        //2 获取读锁
        readLock.lock();
        System.out.println("---read");

        //1 获取写锁
        writeLock.lock();
        System.out.println("---write");

        //3 释放写锁
        // writeLock.unlock();

        //4 释放读锁
        // readLock.unlock();

    }
}
