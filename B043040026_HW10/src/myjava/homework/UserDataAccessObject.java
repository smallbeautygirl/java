package myjava.homework;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.RowSet;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDataAccessObject {
   public void create(User user){

   }

   public String find(User user, JdbcRowSet rowSet){
       try {

           rowSet.setCommand("select * from user");
           rowSet.execute();

           while (rowSet.next()) {
               String id = rowSet.getString("id");
               String password = rowSet.getString("password");

               //若username 和password相符，則return true
               if(user.getId().equals(id)){
                   if(user.getPassword().equals(password)){
                       return "true";
                   }
               }
           }
       } catch (Exception ex) {
           System.out.println(ex);
       }
       return "false";
   }
}
