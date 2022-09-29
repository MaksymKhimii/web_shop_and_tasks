package com.epam.khimii.task9.tcp.handling;

public class DefaultAnswer implements QueryHandler {
    @Override
    public String processQuery() {
        return "unexpected query(";
    }
}