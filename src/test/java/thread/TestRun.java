package thread;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 1:58 AM 2018/12/7
 * @Modified By:
 */
public class TestRun {

  private static int incre(){
    return 1/0;
  }


  public static void main(String[] args){
    System.out.println("test");
    incre();
    System.out.println("test");
  }

}
