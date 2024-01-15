package ru.teamscore.java23.csvsimple;

import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class Weather2Csv {
    public static boolean save(List<Weather> weatherList, Writer writer) {
        try {
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder<Weather>(writer)
                    .build();
            beanToCsv.write(weatherList);
            return true;
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            return false;
        }
    }

    public static List<Weather> load(Reader reader) {
        return new CsvToBeanBuilder<Weather>(reader)
                .withType(Weather.class)
                .build()
                .parse();
    }
}
