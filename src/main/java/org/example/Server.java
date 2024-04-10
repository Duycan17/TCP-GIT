package org.example;

import java.io.*;
import java.net.*;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        {
            ServerSocket server = new ServerSocket(7001);
            System.out.println("Server is started");
            while(true) {
                Socket socket = server.accept();
                new ThreadHandler(socket).start();
            }
        }
    }
}
