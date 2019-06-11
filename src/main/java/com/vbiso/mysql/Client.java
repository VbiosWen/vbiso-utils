package com.vbiso.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 23:49 2019-05-18
 * @Modified By:
 */
public class Client {


  static String driver = "com.mysql.jdbc.Driver";

  static {
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      System.exit(1);
    }
  }


  public static void main(String[] args) throws SQLException {
    Connection connection = null;


    String url = "jdbc:mysql://localhost:3307/botserver";

    String user = "root";

    String password = "root";

    try {
      connection = DriverManager.getConnection(url, user, password);

      if (!connection.isClosed()) {
        System.out.println("Succeeded connecting to the database");
      }

      connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

      connection.setAutoCommit(false);


      Statement statement = connection.createStatement();

      String sql = "select * from book";

      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next()){
        System.out.println(resultSet.getLong("id"));
        System.out.println(resultSet.getString("name"));
      }

      connection.commit();
      resultSet.close();
      statement.close();
      connection.close();

    } catch (SQLException e) {
      if(Objects.nonNull(connection)) {
        connection.rollback();
      }
      e.printStackTrace();
    }

  }

}
