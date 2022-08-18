package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.Parameter;

import java.util.Map;

public interface InputParameter {
    void execute(Map<Parameter, String> parameters);
}
