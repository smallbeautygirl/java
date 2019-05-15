package myjava.homework;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

public class MoneyDataAccessObject {

    public void create(){

    }

    public void read(Money money){

    }

    public String update(Money money, JdbcRowSet rowSet){

        String afterMoney=null;
        String user=null;
        String balance=null;
        try {

            rowSet.setCommand("select * from money");
            rowSet.execute();

            int index=1;
            while (rowSet.next()) {
                user= rowSet.getString("user");
                balance = rowSet.getString("balance");

                //若username 相符
                if(money.getUser().equals(user)){
                    rowSet.updateInt(index,Integer.parseInt(balance)+Integer.parseInt(money.getBalance()));
                    break;
                }
                index++;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

       afterMoney = String.valueOf(Integer.parseInt(balance)+Integer.parseInt(money.getBalance()));
        return afterMoney;
    }


}
