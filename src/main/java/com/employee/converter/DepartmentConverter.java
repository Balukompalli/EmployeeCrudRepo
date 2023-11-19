package com.employee.converter;

import com.employee.Model.Department;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//@Converter(autoApply = true)
public class DepartmentConverter implements AttributeConverter<Department, String> {

    @Override
    public String convertToDatabaseColumn(Department department) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(department, new TypeReference<>() {});
    }

    @Override
    public Department convertToEntityAttribute(String s) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(s, new TypeReference<Department>() {});
    }
}
