package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ThreadHandler extends Thread{
    private Socket socket;

    public ThreadHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream dos = new
                    DataOutputStream(socket.getOutputStream());
            do {
                String time = new Date().toString();
                dos.writeUTF("Thread"+this.getName()+": "+"Server tra lai ngay gio="+time);
                sleep(1000);
            } while (true);

        } catch (IOException | InterruptedException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
