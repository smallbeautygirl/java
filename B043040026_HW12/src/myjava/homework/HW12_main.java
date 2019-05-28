package myjava.homework;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HW12_main {
    public static void main(String []args){
        System.out.print("Input buffer size : ");
        Scanner scanner = new Scanner(System.in);
        int buffer_size=0;
        buffer_size = scanner.nextInt();

        //create SynchronizedBuffer to store ints
        Buffer sharedLocation = new SynchronizedBuffer(buffer_size);

        //create and name each runnable
        Consumer comsumer1 = new Consumer(1,"Consumer1",sharedLocation);
        Consumer comsumer2 = new Consumer(2,"Consumer2",sharedLocation);
        Consumer comsumer3 = new Consumer(3,"Consumer3",sharedLocation);
        Consumer comsumer4 = new Consumer(4,"Consumer4",sharedLocation);
        Producer producer1 = new Producer("Producer1",sharedLocation);

        //create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        //execute the Producer and Consumer  tasks
        executorService.execute(comsumer1);
        executorService.execute(comsumer2);
        executorService.execute(comsumer3);
        executorService.execute(comsumer4);
        executorService.execute(producer1);

        executorService.shutdown();
    }
}
