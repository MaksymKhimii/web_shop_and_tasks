package com.epam.khimii.task5.container;

import com.epam.khimii.task5.chain.FileDateFilter;
import com.epam.khimii.task5.chain.FileExtensionFilter;
import com.epam.khimii.task5.chain.FileNameFilter;
import com.epam.khimii.task5.chain.FileParameterFilter;
import com.epam.khimii.task5.chain.FileSizeFilter;
import com.epam.khimii.task5.util.Parameter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ParameterFilterContainer {
    private Map<Parameter, Function<String, FileParameterFilter>> parameterFilters = new HashMap<>();

    public ParameterFilterContainer() {
        parameterFilters.put(Parameter.NAME, FileNameFilter::new);
        parameterFilters.put(Parameter.EXTENSION, FileExtensionFilter::new);
        parameterFilters.put(Parameter.SIZE, FileSizeFilter::new);
        parameterFilters.put(Parameter.DATE, FileDateFilter::new);
    }

    public Map<Parameter, Function<String, FileParameterFilter>> getParameters() {
        return parameterFilters;
    }
}
