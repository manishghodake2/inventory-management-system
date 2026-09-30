package com.inventory.main;

import java.sql.Connection;
import java.sql.SQLException;
import com.inventory.database.DBConnection;

public class TestConnection {
    public static void main (String A[])
    {
      try
      {
        Connection con = DBConnection.getConnection();
        if(con != null)
        {
          System.out.println("Database Connected Successfully");
        }
      }
      catch(SQLException e)
      {
        System.out.println("Database Connection Failed");
        e.printStackTrace();
      }
    }

}
