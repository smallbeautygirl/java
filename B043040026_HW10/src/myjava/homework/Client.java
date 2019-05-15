package myjava.homework;

import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Client extends ATM {

    private Socket clientSocket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public static void main(String args[]) throws IOException {
        Client client = new Client();
        client.run();
    }

    @Override
    public void run() throws IOException {
        this.processConnection();
        this.getStreams();
        while (true) {
            try {
                System.out.print("(1).Sign In\n(2).Create New Account\n(3).Exit\n-------------------------\n");
                Scanner keyboard = new Scanner(System.in);
                String choice = null;//選擇
                String account = null;//帳戶
                String temppassword;//暫存password
                boolean IsValidPassword;
                String IsExist = null;

                choice = keyboard.next();//輸入選擇
                this.sendData(choice);

                if (choice.equals("1")) {
                    System.out.println("Input your account");
                    account = keyboard.next();
                    System.out.println(account);

                    System.out.println("Input your password");

                    while (true) {//使用者輸入密碼
                        IsValidPassword = true;

                        temppassword = keyboard.next();//輸入密碼
                        System.out.println(temppassword);


                        //判斷密碼是否為六位數
                        if (temppassword.length() > 6) {
                            IsValidPassword = false;
                            System.out.println("password must consist of 6 digits,try again");
                        }


                        //判斷密碼是否是整數
                        for (int i = 0; i < temppassword.length(); ++i) {

                            if (temppassword.charAt(i) < 48 || temppassword.charAt(i) > 57) {
                                IsValidPassword = false;
                                System.out.println("password must integer,try again");
                                break;
                            }
                        }


                        if (IsValidPassword) {//若密碼格式正確，則傳帳戶給server和傳密碼給server驗證
                            this.sendData(account);//傳帳戶給server
                            this.sendData(temppassword);
                            break;
                        }
                    }

                    //若密碼正確
                    if (dataInputStream.readUTF().equals("true")) {
                        System.out.println("signed in");
                            try {
                                System.out.print("(1).Deposit Cash\n(2).Get Cash\n(3).Balance\n(4).Withdraw\n-------------------------\n");
                                String action=null;
                                String Depositmoney=null;

                                action = keyboard.next();
                                this.sendData(action);

                                if(action.equals("1")){
                                    String aftermoney=null;
                                    System.out.println("Input the amount of money you want to deposit");
                                    Depositmoney = keyboard.next();
                                    this.sendData(Depositmoney);
                                    aftermoney = this.dataInputStream.readUTF();

                                    System.out.println("Deposit $"+Depositmoney+", $"+aftermoney+" is in your account");

                                }else if(action.equals("2")){

                                }else if(action.equals("3")){

                                }else if(action.equals("4")){

                                }
                            } catch (Exception E) {
                                System.out.println(E);
                            }
                    } else {
                        System.out.println("Wrong username or password");
                    }

                } else if (choice.equals("2")) {

                } else if (choice.equals("3")) {
                    System.out.println("BYE!!");
                    this.closeConnection();
                    break;
                } else {
                    System.out.println("Please enter correct choice!!(1 or 2 or 3)");
                }

            } catch (Exception E) {
                System.out.println("Failed to create client");
            }
        }
    }

    @Override
    public void closeConnection() throws IOException {
        clientSocket.close();
    }

    @Override
    public void processConnection() throws IOException {
        try {
            Scanner keyboard = new Scanner(System.in);

            String address = null;
            int port = 0;

            System.out.println("Input your address");
            address = keyboard.next();
            System.out.println("Input your port");
            port = keyboard.nextInt();
            System.out.println("connection..");

            //建立連線
            clientSocket = new Socket(address, port);
            System.out.println("Connection");


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void sendData(String message) throws IOException {
        this.dataOutputStream.writeUTF(message);
    }

    @Override
    public void getStreams() throws IOException {
        this.dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        this.dataInputStream = new DataInputStream(clientSocket.getInputStream());
    }
}
