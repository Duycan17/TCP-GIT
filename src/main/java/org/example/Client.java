package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7001);
            DataInputStream din = new
                    DataInputStream(socket.getInputStream());
            while(true){
                String time = din.readUTF();
                System.out.println(time);
            }

            } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
