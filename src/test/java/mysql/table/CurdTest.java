package mysql.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mysql.TestBase;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 18:08 2019-06-11
 * @Modified By:
 */
public class CurdTest extends TestBase {

  private Connection connection;

  @Override
  public void run() {
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      System.exit(-1);
    }
  }

  @Test
  public void testInsert() {
    try {
      //可重复读
      connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
      //设置非自动提交
      connection.setAutoCommit(false);
      Statement statement = connection.createStatement();
      String sql = "insert into author(name,homeland) values('vbiso','rollback')";
      statement.execute(sql);
      String sql1 = "insert into author(name,homeland) values('vbiso','rollbakc1')";
      statement.execute(sql1);
      int a = 1 / 0; //在 commit 执行之前抛出运行时异常事务不会提交,在 commit 执行之后抛出运行时异常事务会提交.
      connection.commit();

    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      closeConnection();
    }
  }

  @Test
  public void testInsertAutoCommit() {
    try {
      connection.setAutoCommit(true);
      Statement statement = connection.createStatement();
      String sql = "insert into author(name,homeland) values('vbiso','autoCommit')";
      boolean execute = statement.execute(sql);
      System.out.println(execute);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  @Test
  public void prepareInsert() {
    try {
      String sql = "insert into author(name,homeland) values(?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, "vbiso");
      preparedStatement.setString(2, "hahhah");
      preparedStatement.execute();
    } catch (SQLException se) {
      se.printStackTrace();
    }finally {
      closeConnection();
    }

  }

  @Test
  public void prepareDelete() {
    try {
      connection.setAutoCommit(true);
      String sql = "delete from author where name = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, "'vbiso' or 1=1");
      preparedStatement.execute();
    } catch (SQLException se) {
     se.printStackTrace();
    }finally {
      closeConnection();
    }
  }

  @Test
  public void prepareSelect() {
    try {
      connection.setAutoCommit(true);
      String sql = "select id,name,homeland from author limit ?,?";
      PreparedStatement preparedStatement = connection
          .prepareStatement(sql, new String[]{"id", "name", "homeland"});
      preparedStatement.setInt(1, 0);
      preparedStatement.setInt(2, 50);
      ResultSet resultSet = preparedStatement.executeQuery();
      List<author> authors = new ArrayList<>();
      while (resultSet.next()) {
        author author = new author();
        author.setId(resultSet.getLong("id"));
        author.setHomeland(resultSet.getString("homeland"));
        author.setName(resultSet.getString("name"));
        authors.add(author);
      }
      authors.forEach(System.out::println);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  @Test
  public void testUpdate(){
    try {
      connection.setAutoCommit(true);
      String sql = "update author set name = ? where id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,"wenliujie");
      preparedStatement.setLong(2,1L);
      int i = preparedStatement.executeUpdate();
      System.out.println(i);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testTransaction(){
    Savepoint savepoint = null;
    try {
      connection.setAutoCommit(false);
      connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

      String sql = "insert into author(name,homeland) values(?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,"testTransaction");
      preparedStatement.setString(2,"transaction");
      preparedStatement.executeUpdate();

      String update = "update author set name = ? where name = ?";
      PreparedStatement preparedStatement1 = connection.prepareStatement(update);
      preparedStatement1.setString(1,"updateTransaction");
      preparedStatement1.setString(2,"testTransaction");
      preparedStatement1.executeUpdate();

      savepoint = connection.setSavepoint();

      String select = "select * from author id =1";
      PreparedStatement preparedStatement2 = connection.prepareStatement(select);
      ResultSet resultSet = preparedStatement2.executeQuery();

    } catch (SQLException e) {
      try {
        connection.rollback(savepoint);
      } catch (SQLException ex) {
      }
    }
    try {
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      closeConnection();
    }
  }


  private void closeConnection() {
    try {
      if (!connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private class author {

    private long id;

    private String name;

    private String homeland;

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getHomeland() {
      return homeland;
    }

    public void setHomeland(String homeland) {
      this.homeland = homeland;
    }

    @Override
    public String toString() {
      return "author{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", homeland='" + homeland + '\'' +
          '}';
    }
  }

}
