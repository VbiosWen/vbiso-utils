import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 16:03 2019-06-19
 * @Modified By:
 */

/**
 * @see ReentrantLock#tryRelease
 */
public class TestTest {


  static {
    System.out.println(true);
  }

  @Test
  public void mt() {

    ReentrantLock lock = new ReentrantLock();



    try {

    }finally {
      lock.unlock();
    }
  }

  @Test
  public void binaryOperation(){
    int i = -1 ;
    i >>>= 1;
    System.out.println(i + -1);
    System.out.println(Math.pow(2,16));
    System.out.println(Integer.MIN_VALUE);


    long l = -1 ;
    l >>>= 1;
    System.out.println(l + -1);
    System.out.println(Long.MAX_VALUE);

    short s = -1;
    s >>>=1;
    System.out.println(s);

    byte b = -1;
    b >>>=1;
    System.out.println(b);
  }

}
