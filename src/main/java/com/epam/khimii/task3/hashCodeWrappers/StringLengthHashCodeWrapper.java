package com.epam.khimii.task3.hashCodeWrappers;

import java.util.Objects;

/**
 * String Wrapper which override hashCode.
 * HashCode computed by string length.
 *
 * @author Maksym Khimii
 */
public class StringLengthHashCodeWrapper {

    private final String name;

    public StringLengthHashCodeWrapper(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.length();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StringLengthHashCodeWrapper wrapper = (StringLengthHashCodeWrapper) object;
        return Objects.equals(name, wrapper.name);
    }
}

