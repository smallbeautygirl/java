package myjava.homework;

public class MySqLCSVCon extends ConnectionTemplate{
    /*
     *    you should complete this class
     */
    public void setDBDriver(){
        System.out.println("Setting MySOL DB drivers...");
    }

    public void setCredentials(){
        System.out.println("Setting credentials for MySOL DB...");
    }

    public void setData(){
        System.out.println("Setting up data from csv file....");
    }

    public boolean disableLogging(){
        return false;
    }
}
