package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 23:19 2019-07-01
 * @Modified By:
 */
public class ReenterLockTest {


  @Test
  public void testReentrantLock() throws InterruptedException {
    ReentrantLock lock1 = new ReentrantLock();
    Condition condition = lock1.newCondition();

    ReentrantLock lock2 = new ReentrantLock();
    Condition condition1 = lock2.newCondition();

    TestTask testTask = new TestTask(1,lock1,lock2);
    TestTask testTask1 = new TestTask(2,lock1,lock2);
    Thread thread = new Thread(testTask);
    Thread thread1 = new Thread(testTask1);
    thread.start();
    thread1.start();
    TimeUnit.SECONDS.sleep(10);
    thread1.interrupt();
    Semaphore semaphore = new Semaphore(5);
  }

  private class TestTask implements Runnable{

    private final int lock;

    private final ReentrantLock lock1;

    private final ReentrantLock lock2;

    public TestTask(int lock, ReentrantLock lock1, ReentrantLock lock2) {
      this.lock = lock;
      this.lock1 = lock1;
      this.lock2 = lock2;
    }

    @Override
    public void run() {
      if(lock == 1){
        try {
          lock1.lockInterruptibly();
          TimeUnit.SECONDS.sleep(500);
        } catch (InterruptedException e) {
          try {
            lock2.lockInterruptibly();
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
      }else{
        try {
          lock2.lockInterruptibly();
          TimeUnit.SECONDS.sleep(500);
        } catch (InterruptedException e) {
          try {
            lock1.lockInterruptibly();
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }finally {
            if(lock1.isHeldByCurrentThread()){
              lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
              lock2.unlock();
            }
          }
        }
      }
    }
  }

}
