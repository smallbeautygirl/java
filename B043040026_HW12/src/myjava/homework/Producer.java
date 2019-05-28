package myjava.homework;

public class Producer implements Runnable{
    private final Buffer sharedLocation;
    private String name;

    public Producer(String name,Buffer sharedLocation){
        this.sharedLocation=sharedLocation;
        this.name =name;
    }

    public void run(){
        try {
            for(int i=1;i<=50;++i){
                sharedLocation.set(i);
            }
        }catch (Exception E){
            System.out.println(E.getMessage());
        }
    }
}
