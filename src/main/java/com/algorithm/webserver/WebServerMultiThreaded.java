package com.algorithm.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class WebServerMultiThreaded {



    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket  = new ServerSocket(83);

        while(true){
            Socket socket = serverSocket.accept();

            Runnable  runnable = () -> {
                try {
                    processRequest(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            new Thread(runnable).start();

        }

    }

    private static void processRequest(Socket clientSocket) throws IOException{
        System.out.println(Thread.currentThread().getName());
        InputStream input  = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

       // storeRequest(input);
        long time = System.currentTimeMillis();
        String  responseDocument = "<html><body> Singlethreaded Server: " +
                time +  "</body></html>";

        String responseHeader =
                "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + responseDocument.length() +
                        "\r\n\r\n";

        output.write(responseHeader.getBytes("UTF-8"));
        output.write(responseDocument .getBytes("UTF-8"));
        output.close();
        input.close();
        System.out.println("Request processed: " + time);

    }

    private static void storeRequest(InputStream input) throws IOException {
        other(input);
        InputStreamReader bs = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(bs);
        br.lines().forEach(System.out::println);
    }


    private static void other(InputStream input)throws IOException{
        int data = input.read();
        int count =0;
        while(data != -1) {
            // do something with data variable
            count++;
            if(count>5){
                break;
            }
            data = input.read(); // read next byte
            System.out.print(data);
        }
    }
}
