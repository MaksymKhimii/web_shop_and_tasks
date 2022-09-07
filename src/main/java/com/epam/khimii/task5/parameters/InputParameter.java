package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.chain.IFilter;

import java.text.ParseException;

public interface InputParameter {
    IFilter execute(IFilter filter) throws ParseException;
}
