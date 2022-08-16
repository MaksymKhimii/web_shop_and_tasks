package com.epam.khimii.task5.container;

import com.epam.khimii.task5.parameters.InputDateParameter;
import com.epam.khimii.task5.parameters.InputExtensionParameter;
import com.epam.khimii.task5.parameters.InputNameParameter;
import com.epam.khimii.task5.parameters.InputParameter;
import com.epam.khimii.task5.parameters.InputSizeParameter;

import java.util.ArrayList;
import java.util.List;

public class ParametersContainer {
    private ArrayList<InputParameter> parameters = new ArrayList<>();

    public ParametersContainer() {
        parameters.add(new InputNameParameter());
        parameters.add(new InputExtensionParameter());
        parameters.add(new InputSizeParameter());
        parameters.add(new InputDateParameter());
    }

    public List<InputParameter> getParameters() {
        return parameters;
    }
}