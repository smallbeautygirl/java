package myjava.homework;

public class Money {
    private String user;
    private String balance;

    public Money(String user,String balance){
        this.balance=balance;
        this.user = user;
    }

    public String getUser(){
        return this.user;
    }

    public String getBalance(){
        return this.balance;
    }

    public void setUser(String user){
        this.user=user;
    }

    public void setBalance(String balance){
        this.balance = balance;
    }
}
