package com.waternet.domin;

public interface ExcelValueFormatter {
    Object formatValue(Class<?> returnType, Object value);
}