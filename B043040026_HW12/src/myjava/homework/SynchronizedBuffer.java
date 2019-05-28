package myjava.homework;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBuffer implements Buffer {

    //Lock to control synchronization with this buffer
    private final Lock accessLock = new ReentrantLock();

    //conditions to control reading and writing
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private int[] buffer;//shared by producer and comsumer threads
    private int occupiedCells = 0;//count number of buffers used
    private int writeIndex = 0;//index of next element to write to
    private int readIndex = 0;//index of next element to read
    private int bufferSize = 0;
    private boolean IsEnd=false;//確認是否到50
    private int IsWritingEnd=0;//consumer要印出最後結果
    private int []number;

    private boolean[] choosing;

    public SynchronizedBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer = new int[this.bufferSize];

        //initialize buffer content -1
        for (int i = 0; i < this.bufferSize; ++i) {
            this.buffer[i]=-1;
        }

        this.choosing = new boolean[4];
        for(int i=0;i<4;++i){
            this.choosing[i]=false;
        }

        this.number = new int[4];
        for(int i=0;i<4;++i){
            this.number[i]=0;
        }
    }

    //place int value into buffer
    public void set(int value) throws InterruptedException {
        this.accessLock.lock();//lock this object

        //output thread information and buffer information, then wait
        try {
            //while buffer is not empty, place thread in waiting state
            while (this.occupiedCells == this.bufferSize) {
                System.out.println("Buffer is full. Producer1 waits.");
                this.canWrite.await();//wait until buffer is empty
            }//end write

            this.buffer[this.writeIndex] = value;//set new buffer value

            //update circular write index
            this.writeIndex = (this.writeIndex + 1) % this.bufferSize;

            ++this.occupiedCells;//one more buffer is full
            this.displayState("Producer1 writes " + value);

            if(value==50){
                System.out.print("Producer1 done producing\nTerminating Producer1\n\n");
            }
            //signal any threads waiting to read from buffer
            this.canRead.signalAll();
        } finally {
            this.accessLock.unlock();//unlock this object
        }
    }

    public int get(String name) throws InterruptedException {
        int readValue = 0;//initialize value read from buffer
        this.accessLock.lock();//lock this object

        //output thread information and buffer information, then wait
        try {
//
//            this.choosing[Character.getNumericValue(name.charAt(8))]=true;//正在選牌
//            this.number[Character.getNumericValue(name.charAt(8))] = this.max(number)+1;//選的牌為目前最大的加一
//            this.choosing[Character.getNumericValue(name.charAt(8))] = false;//選完了

           // for(int j=0;j<4;++j){
             //   while (this.choosing[Character.getNumericValue(name.charAt(8))]);
               // while (number[j]!=0 && (number[j]<number[Character.getNumericValue(name.charAt(8))] || (this.number[j]==this.number[Character.getNumericValue(name.charAt(8))] && Character.getNumericValue(name.charAt(8))>j)));
                //if there is no data to read, place thread in waiting state
                while (this.occupiedCells == 0) {
                    System.out.println("Buffer is empty. "+name+" waits.");
                    if(IsEnd){
                        return 0;
                    }
                    this.canRead.await();//wait until buffer is full
                }
            //}
            //critical section
                readValue = this.buffer[this.readIndex];//read value from buffer

                //update circular read index
                this.readIndex = (this.readIndex+1)%this.bufferSize;

                --this.occupiedCells;//one fewer buffer cells are occupied
                displayState(name +" reads " + readValue);

                //signal any threads waiting for buffer to be empty
                this.canWrite.signalAll();
            //critical section

                //this.number[Character.getNumericValue(name.charAt(8))]=0;
        }finally{
            this.accessLock.unlock();//unlock this object
        }
        if (readValue==50){
            this.IsEnd=true;
        }
        return readValue;
    }

    //display current operation and buffer state
    public void displayState(String operation){

        System.out.println(operation+" (buffer cells occupied: "+this.occupiedCells+")");
        //output operation and number of occupied buffer cells
        System.out.print("buffer cells: ");
        for (int i = 0; i < this.bufferSize; ++i) {
            if (this.buffer[i] == -1) {
                System.out.print("  " + this.buffer[i] + " ");
            } else {
                System.out.printf("  %2d ",this.buffer[i]);
            }
        }
        System.out.print("\n              ");
        for (int i = 0; i < this.bufferSize; ++i) {
            System.out.print(" ----");
        }
        System.out.print("\n               ");

        for(int i=0;i<this.bufferSize;++i){
            if(i == this.writeIndex&&i == this.readIndex){
                System.out.print(" WR");//both write and read index
            }
            else if(i == this.writeIndex){
                System.out.print(" W   ");//just write index
            }
            else if(i == this.readIndex){
                System.out.print("  R  ");//just read index
            }else{
                System.out.print("     ");
            }
        }
        System.out.println("\n");
    }

    public void printFinal(ArrayList arrayList,int sum,String name) throws InterruptedException{
        this.accessLock.lock();//lock this object

        try {
            //while other consumer writing final message
            while (this.IsWritingEnd==1) {
                this.canWrite.await();//wait until no other consumer is writing end
            }//end write
            this.IsWritingEnd++;

            System.out.println(""+name+" read "+arrayList.size()+" numbers:");
            for(int i=0;i<arrayList.size();++i){
                System.out.print(arrayList.get(i)+"  ");
            }
            System.out.println("\n"+name+" read values totaling "+sum+"\n");

            this.IsWritingEnd=0;
            //signal any threads waiting to read from buffer
            this.canRead.signalAll();
        } finally {
            this.accessLock.unlock();//unlock this object
        }
    }

    public int max(int []number){
        int max = number[0];
        for(int i=0;i<4;++i){
            if(number[i]>max){
                max = number[i];
            }
        }

        return max;
    }
}
