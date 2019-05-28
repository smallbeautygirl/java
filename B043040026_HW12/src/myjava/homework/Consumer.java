package myjava.homework;

import java.util.ArrayList;

public class Consumer implements Runnable {
    private final Buffer sharedLocation;
    private String name;
    private ArrayList arrayList = new ArrayList();
    private int sum=0;
    private int threadId;

    public Consumer(int threadId,String name, Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
        this.name = name;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        try{
            int readValue=0;
            while (true){
                readValue = this.sharedLocation.get(this.name);
                this.sum+=readValue;
                if(readValue == 0){
                    break;
                }else{
                    this.arrayList.add(readValue);
                }
            }
            this.sharedLocation.printFinal(this.arrayList,this.sum,this.name);

        }catch (Exception E){
            System.out.println(E.getMessage());
        }
    }
}
