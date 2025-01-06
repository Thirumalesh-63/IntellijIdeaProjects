package com.zapcom.kafkaproducer2.model;


import org.springframework.core.io.ClassPathResource;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class CsvReadUtils {

    public static List<User> readDataFromCsv() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader
                (new ClassPathResource("Users.csv").getInputStream()))) {
            CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                    .withType(User.class)
                    .build();

            return csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
            return null;
        }
    }
}