package mysql.table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import mysql.TestBase;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 16:40 2019-06-11
 * @Modified By:
 */
public class TableTest extends TestBase {

  private Connection connection;

  @Override
  public void run() {
    try {
      System.out.println("before run it");
      this.connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  @Test
  public void testGetTableInfo(){
    try {

      if(connection.isClosed()){
        System.exit(-1);
      }

      DatabaseMetaData metaData = connection.getMetaData();

      ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
      while (tables.next()){
        //table belong database
        System.out.println(tables.getString(1));
        //table schema 表模式
        System.out.println(tables.getString(2));
        // table name
        System.out.println(tables.getString(3));
        // table type table | view  and so on.
        System.out.println(tables.getString(4));

        //获取表中的所有字段信息
        ResultSet columns = metaData.getColumns(null, "%", tables.getString(3), "%");
        while (columns.next()){
          System.out.println(columns.getString("COLUMN_NAME"));
          System.out.println(columns.getString("TYPE_NAME"));
          System.out.println(columns.getInt("DATA_TYPE"));
          System.out.println(columns.getString("IS_AUTOINCREMENT"));

        }
        System.out.println("-------------------------------------");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        this.connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
