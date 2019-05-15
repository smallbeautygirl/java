package myjava.homework;//Represents a bank account

public class Account {
	
	/* Fill your code here */
   private int accountNumber;
   private int pin;
   private int totalBalance;
   private int debt;
   private char creditLevel;

   public Account(int i1,int i2,int i3,int i4,char c1){
       accountNumber=i1;
       pin=i2;
       totalBalance=i3;
       debt=i4;
       creditLevel=c1;
   }
   public boolean validatePIN(int in){
       return in==this.pin;
   }
   public int getAccountNumber(){
       return accountNumber;
   }
   public int getTotalBalance(){
       return totalBalance;
   }
   public char getCreditLevel(){
       return creditLevel;
   }
   public int getDebt(){
       return debt;
   }
   public void setTotalBalance(int in){
       totalBalance=in;
   }
   public void setDebt(int in){
       debt=in;
   }
}
