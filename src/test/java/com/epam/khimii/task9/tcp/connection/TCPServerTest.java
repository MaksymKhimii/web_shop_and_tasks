package com.epam.khimii.task9.tcp.connection;

import com.epam.khimii.task9.tcp.handling.DefaultAnswer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPServerTest {
    private DataOutputStream out;
    private BufferedReader in;
    private String query;
    private String answer;

    @Before
    public void beforeTest() {
        try {
            Socket clientSocket = new Socket("localhost", 81);
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("connected to server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countTest() {
        query = "get count";
        try {
            out.writeBytes(query + "\n");
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("7", answer);
    }

    @Test
    public void getItemTest() {
        query = "get item=apple";
        try {
            out.writeBytes(query + "\n");
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("apple | 11", answer);
    }

    @Test
    public void DefaultAnswerFromServerTest() {
        query = "lalala";
        try {
            out.writeBytes(query + "\n");
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(new DefaultAnswer().processQuery(), answer);
    }
}