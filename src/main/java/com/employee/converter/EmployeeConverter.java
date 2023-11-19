package com.employee.converter;

import com.employee.Model.Department;
import com.employee.Model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter(autoApply = true)
public class EmployeeConverter implements AttributeConverter<List<Employee>, String> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Employee> employees) {
        return objectMapper.convertValue(employees, new TypeReference<String>() {});
    }

    @Override
    public List<Employee> convertToEntityAttribute(String s) {
        return objectMapper.convertValue(s, new TypeReference<List<Employee>>() {});
    }
}
