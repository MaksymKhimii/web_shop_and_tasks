package com.epam.khimii.task9.http;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task9.ProductLoader;
import com.epam.khimii.task9.http.factory.QueryProcessCreator;
import com.epam.khimii.task9.http.factory.QueryResponseFactory;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

public class HttpServer {
    private static final QueryResponseFactory responseFactory = new QueryResponseFactory();
    private static final List<Product> products = ProductLoader.load();

    public static void main(String[] args) {
        com.sun.net.httpserver.HttpServer server;
        try {
            server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8500), 0);
            HttpContext context = server.createContext("/shop");
            context.setHandler(HttpServer::handleRequest);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        String response;
        QueryProcessCreator queryProcessCreator = responseFactory.createResponse(requestURI);
        response = queryProcessCreator.processQuery(products);
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}