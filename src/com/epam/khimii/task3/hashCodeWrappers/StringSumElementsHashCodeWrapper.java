package com.epam.khimii.task3.hashCodeWrappers;


import java.util.Objects;

/**
 * String Wrapper which override hashCode.
 * HashCode computed by sum of first four chars of string.
 * If length of string is less than four elements, sum all elements.
 *
 * @author Maksym Khimii
 */
public class StringSumElementsHashCodeWrapper {
    private final String name;

    public StringSumElementsHashCodeWrapper(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < Math.min(name.length(), 4); i++) {
            sum += name.charAt(i);
        }
        return sum;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StringSumElementsHashCodeWrapper wrapper = (StringSumElementsHashCodeWrapper) object;
        return Objects.equals(name, wrapper.name);
    }
}
