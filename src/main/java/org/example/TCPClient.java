package org.example;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            int num1 = 10;
            int num2 = 20;
            dos.writeInt(num1);
            dos.writeInt(num2);
            dos.flush();
            System.out.println("Sent numbers to server: " + num1 + ", " + num2);
            int sum = dis.readInt();
            System.out.println("Sum received from server: " + sum);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
