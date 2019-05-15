package myjava.homework;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ATM {
    public abstract void  run() throws IOException;
    public abstract void closeConnection() throws IOException;
    public abstract void processConnection() throws IOException;
    public abstract void sendData(String message) throws IOException;
    public abstract void getStreams() throws IOException;
}
