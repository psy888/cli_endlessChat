package com.psy888;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //tcp - гарантирует доставку
        //udp - отправка (streams)
        Scanner scanner = new Scanner((System.in));
//        try (Socket socket = new Socket("172.30.2.121", 6789);
        try (Socket socket = new Socket("192.168.0.103", 6789);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            String msgFromSrv =  bufferedReader.readLine();
            System.out.println(msgFromSrv);
            bufferedWriter.write("Hello from client Pasha\n");
            bufferedWriter.flush();
            do {
                String str = scanner.nextLine();
                str+="\r";
                bufferedWriter.write(str);
                bufferedWriter.flush();
            } while (true);

        } catch (UnknownHostException uhe){
            uhe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
