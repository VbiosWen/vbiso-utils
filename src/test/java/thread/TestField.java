package thread;

import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 12:39 PM 2019/4/2
 * @Modified By:
 */
public class TestField {


  @Test
  public void testAtomic(){

    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    if(atomicBoolean.compareAndSet(false,true)){
      System.out.println(atomicBoolean.get());
    }

    atomicBoolean.compareAndSet(true,false);

    System.out.println(atomicBoolean.get());
  }

}
