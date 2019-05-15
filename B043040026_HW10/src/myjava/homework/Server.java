package myjava.homework;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.sql.*;

import static javafx.scene.input.KeyCode.R;

public class Server extends ATM {
    private Socket connectionSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private RowSetFactory rowSet;
    private JdbcRowSet jdbcRowSet;
    public static void main(String args[]) throws IOException {
        Server server = new Server();
        server.processConnection();
    }

    @Override
    public void run() throws IOException {
        this.processConnection();
    }

    @Override
    public void closeConnection() throws IOException {
        connectionSocket.close();
    }

    @Override
    public void processConnection() throws IOException {
        try {
            ServerSocket welcomeSocket = new ServerSocket(12345);
            System.out.println("Server listening on port 12345");

            this.DBConnect();//連線資料庫
            System.out.println("database connect success!!");
            while (true) {
                connectionSocket = welcomeSocket.accept();
                System.out.println("Client connection success!!");
                this.getStreams();

                UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
                MoneyDataAccessObject moneyDataAccessObject = new MoneyDataAccessObject();
                while(true){
                    String IsCorrectPassword = null;
                    String account = null;
                    String password = null;
                    String action = null;
                    String Depositmoney = null;//要存的錢


                    String choice = this.dataInputStream.readUTF();//讀choice
                    System.out.println(choice);

                    //若是sign in
                    if (choice.equals("1")) {

                        account = this.dataInputStream.readUTF();//讀account
                        System.out.println(account);
                        password = this.dataInputStream.readUTF();//讀password
                        System.out.println(password);

                        User user = new User(account, password);
                        IsCorrectPassword = userDataAccessObject.find(user,this.jdbcRowSet);//檢查這個account的password是否正確
                        System.out.println(IsCorrectPassword);
                        this.sendData(IsCorrectPassword);

                        //若這個password正確(也就是使用者成功登入了)
                        if (IsCorrectPassword.equals("true")) {
                            Money money=new Money(account,"0");
                            String aftermoney=null;
                            action = this.dataInputStream.readUTF();

                            if (action.equals("1")) {//存錢
                                Depositmoney = this.dataInputStream.readUTF();
                                money.setBalance(Depositmoney);

                                aftermoney=moneyDataAccessObject.update(money,this.jdbcRowSet);
                                this.sendData(aftermoney);
                            } else if (action.equals("2")) {//領錢

                            } else if (action.equals("3")) {//看餘額

                            } else if (action.equals("4")) {

                            }
                        }


                    } else if (choice.equals("2")) {

                    } else if (choice.equals("3")){
                        //this.closeConnection();
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Error!!");
        }
    }

    @Override
    public void sendData(String message) throws IOException {
        this.dataOutputStream.writeUTF(message);
    }

    @Override
    public void getStreams() throws IOException {
        this.dataInputStream = new DataInputStream(connectionSocket.getInputStream());
        this.dataOutputStream = new DataOutputStream(connectionSocket.getOutputStream());
    }

    public void DBConnect() {
        try {
//            //Class 的靜態 forName() 方法實現動態加載類別
//            Class.forName("com.mysql.jdbc.Driver");
//            //3306|MySQL開放此端口
//            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_hw10", "root", "");
//            this.statement = this.connection.createStatement();

            this.rowSet = RowSetProvider.newFactory();
            this.jdbcRowSet = rowSet.createJdbcRowSet();
            this.jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/java_hw10");
            this.jdbcRowSet.setUsername("root");
            this.jdbcRowSet.setPassword("");

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

//        try {
//            String query = "select * from money";
//            this.resultSet = this.statement.executeQuery(query);
//            System.out.println("Records for Database");
//            while (this.resultSet.next()) {
//                int balance = this.resultSet.getInt("balance");
//                String name = this.resultSet.getString("user");
//                System.out.println(" name= " + name + " balance=" + balance);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
    }
}
