package com.epam.khimii.task1.entity;


import java.math.BigDecimal;
import java.util.Objects;

public class GraphicsCard extends ComputerPart {

    private int memory;
    private String memoryType;
    private String connector;

    public GraphicsCard() {
    }

    public GraphicsCard(String name, BigDecimal price, String country,
                        String category, String purpose, int memory, String memoryType, String connector) {
        super(name, price, country, category, purpose);
        this.memory = memory;
        this.memoryType = memoryType;
        this.connector = connector;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Override
    public String toString() {
        return "GraphicsCard{" +
                "memory=" + memory +
                ", memoryType='" + memoryType + '\'' +
                ", connector='" + connector + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GraphicsCard that = (GraphicsCard) o;
        return memory == that.memory && Objects.equals(memoryType, that.memoryType) && Objects.equals(connector, that.connector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memory, memoryType, connector);
    }
}

