package mysql;

import org.junit.Before;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 16:38 2019-06-11
 * @Modified By:
 */
public abstract class TestBase {

  protected static String driver = "com.mysql.jdbc.Driver";

  protected String url = "jdbc:mysql://localhost:3307/botserver";

  protected String user = "root";

  protected String password = "root";

  static {
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Before
  public abstract void run();

}
