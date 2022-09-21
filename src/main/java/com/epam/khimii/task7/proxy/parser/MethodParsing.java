package com.epam.khimii.task7.proxy.parser;

import java.lang.reflect.Method;
import java.util.Locale;

public class MethodParsing {
    public static String getFieldNameFromMethod(Method method){
        String methodName = method.getName();
        if(methodName.contains("get") || methodName.contains("set")){
            methodName = methodName.substring(3);
        }
        return  methodName.substring(0, 1).toLowerCase(Locale.ROOT) + methodName.substring(1);
    }
}
