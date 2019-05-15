package myjava.homework;

public class User {
    private String id;
    private String password;

    public User(String id,String password){
        this.password=password;
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
