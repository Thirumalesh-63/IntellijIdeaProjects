package com.zapcom.mapstruct.model;

import java.util.HashMap;
import java.util.Map;

public class StudentMapper {

    private Map<String, Object> extraFields = new HashMap<>();

    public void addExtraField(String fieldName, Object value) {
        extraFields.put(fieldName, value);
    }

    public Map<String, Object> getExtraFields() {
        return extraFields;
    }
}
