package myjava.homework;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

public class MoneyDataAccessObject {

    public String create(Money money,JdbcRowSet rowSet) {
        try{
            rowSet.setCommand("select * from money");
            rowSet.execute();
            rowSet.moveToInsertRow();
            rowSet.updateString("user",money.getUser());
            rowSet.updateString("balance",money.getBalance());
            rowSet.insertRow();

            return "finish";
        }catch (Exception E){
            System.out.println(E.getMessage());
            return "";
        }
    }

    public String read(Money money,JdbcRowSet rowSet) {
            try{
                rowSet.setCommand("select * from money where user = \"" + money.getUser() + "\"");
                rowSet.execute();

                rowSet.first();//ou just set the pointer to the first record and go from there
                String balance = rowSet.getString("balance");

                return balance;
            }catch (Exception E){
                System.out.println(E.getMessage());
                return "";
            }
    }

    public String update(Money money, JdbcRowSet rowSet, String action) {

        String afterMoney = null;
        String user = null;
        String balance = null;
        try {

            rowSet.setCommand("select * from money where user = \"" + money.getUser() + "\"");
            rowSet.execute();

            rowSet.first();//ou just set the pointer to the first record and go from there
            balance = rowSet.getString("balance");
            System.out.println(balance);

            if (action.equals("1")) {//若是存錢
                rowSet.updateInt("balance", Integer.parseInt(balance) + Integer.parseInt(money.getBalance()));//在結果集中臨時修改
                rowSet.updateRow();//更新到資料庫中
                afterMoney = String.valueOf(Integer.parseInt(balance) + Integer.parseInt(money.getBalance()));
            } else {//若是領錢
                if(Integer.parseInt(balance)<Integer.parseInt(money.getBalance())){
                    return "fail";
                }
                rowSet.updateInt("balance", Integer.parseInt(balance) - Integer.parseInt(money.getBalance()));//在結果集中臨時修改
                rowSet.updateRow();//更新到資料庫中
                afterMoney = String.valueOf(Integer.parseInt(balance) - Integer.parseInt(money.getBalance()));
            }


            System.out.println(afterMoney);
            return afterMoney;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }


    }


}
