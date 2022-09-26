package com.epam.khimii.task9.tcp.connection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 81);
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader in =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("connected to server");
        while (true) {
            System.out.println("enter data to send");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            out.writeBytes(msg + "\n");
            System.out.println("response from server : " + in.readLine());
        }
    }
}