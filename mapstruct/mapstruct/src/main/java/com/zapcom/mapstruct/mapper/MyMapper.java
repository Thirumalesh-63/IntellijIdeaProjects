package com.zapcom.mapstruct.mapper;

import com.zapcom.mapstruct.model.Student;
import com.zapcom.mapstruct.model.StudentMapper;
import com.zapcom.mapstruct.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.lang.reflect.Field;


@Mapper(componentModel = "spring")
public interface MyMapper {

    @org.mapstruct.Mapping(source = "id", target = "id")
    @org.mapstruct.Mapping(source = "name", target = "name")
    void sourceToData(Student Student, @MappingTarget User user);

    // This method will use reflection to map dynamic fields
    default StudentMapper mapExtraFields(Student source) {
        StudentMapper extraModel = new StudentMapper();

        // Using reflection to get all fields from the SourceModel
        Field[] fields = Student.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                // Skip known fields (those already mapped explicitly)
                if (!fieldName.equals("name") && !fieldName.equals("id")) {
                    extraModel.addExtraField(fieldName, field.get(source));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return extraModel;
    }


}
