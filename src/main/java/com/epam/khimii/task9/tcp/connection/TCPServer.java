package com.epam.khimii.task9.tcp.connection;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task9.ProductLoader;
import com.epam.khimii.task9.tcp.handling.QueryHandler;
import com.epam.khimii.task9.tcp.handling.QueryResponseFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class TCPServer {
    private static final List<Product> products = ProductLoader.load();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(81);
        while (true) {
            Socket s = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String answer;
            while (true) {
                String received = in.readLine();
                System.out.println("received: " + received);
                QueryResponseFactory responseFactory = new QueryResponseFactory();
                QueryHandler queryHandler = responseFactory.createResponse(received, products);
                answer = queryHandler.processQuery();
                out.writeBytes(answer + "\n");
                out.flush();
            }
        }
    }
}