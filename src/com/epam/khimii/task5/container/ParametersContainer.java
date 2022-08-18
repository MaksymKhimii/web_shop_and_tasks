package com.epam.khimii.task5.container;

import com.epam.khimii.task5.parameters.InputDateParameter;
import com.epam.khimii.task5.parameters.InputExtensionParameter;
import com.epam.khimii.task5.parameters.InputNameParameter;
import com.epam.khimii.task5.parameters.InputParameter;
import com.epam.khimii.task5.parameters.InputSizeParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParametersContainer {
    private ArrayList<InputParameter> parameters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public ParametersContainer() {
        parameters.add(new InputNameParameter(scanner));
        parameters.add(new InputExtensionParameter(scanner));
        parameters.add(new InputSizeParameter(scanner));
        parameters.add(new InputDateParameter(scanner));
    }

    public List<InputParameter> getParameters() {
        return parameters;
    }
}