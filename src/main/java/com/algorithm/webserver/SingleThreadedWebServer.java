package com.algorithm.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

public class SingleThreadedWebServer {

    /*
            Example curl localhost:82
            curl --data "param1=value1&param2=value2"  localhost:82
     */
    public static void main(String[] args) throws IOException {
        System.out.println("started");
        ServerSocket serverSocket = new ServerSocket(82);
        while (true) {
            final Socket socket = serverSocket.accept();  //Socket  is  an  endpoint for  communication  between  two  machines
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

    //    storeRequest(input);
        long time = System.currentTimeMillis();
        String responseDocument = "<html><body> Singlethreaded Server: " +
                time + "</body></html>";

        String responseHeader =
                "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + responseDocument.length() +
                        "\r\n\r\n";

        output.write(responseHeader.getBytes("UTF-8"));
        output.write(responseDocument.getBytes("UTF-8"));
        output.close();
        input.close();
        System.out.println("Request processed: " + time);
    }

    /*
            Note  reading  stream directly - MEssy  and maybe  garbage  at end  of stream
     */
    private static void storeRequest(InputStream input) throws IOException {
//       int data = input.read();
//        int count =0;
//        while(data != -1) {
//            // do something with data variable
//            count++;
//            if(count>12){
//                break;
//            }
//            data = input.read(); // read next byte
//            System.out.print(data);
//        }
        InputStreamReader bs = new InputStreamReader(input);
        try (BufferedReader br = new BufferedReader(bs)) {

            String strCurrentLine;
            int count=0;
            while ((strCurrentLine = br.readLine()) != null) {
                count++;
                if(count>10)
                    break;
                System.out.println(strCurrentLine);
            }

            //  br.lines.forEach(System.out::println);
//            lines.close();
        }


    }
}
