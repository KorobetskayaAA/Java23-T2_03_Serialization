package ru.teamscore.java23.csvsimple;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "resources/weather.csv";

        try (Writer writer = new FileWriter(fileName)) {
            if (Weather2Csv.save(getWeatherList(), writer)) {
                System.out.println();
            } else {
                System.err.println("Неверный формат данных для записи");
            }
            ;
        } catch (IOException e) {
            System.err.printf("Ошибка записи в файл %s: %s\n", fileName, e.getMessage());
        }

        try (FileReader reader = new FileReader(fileName)) {
            var weatherList = Weather2Csv.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.printf("Ошибка чтения в файла %s: %s\n", fileName, e.getMessage());
        }
    }

    private static List<Weather> getWeatherList() {
        return List.of(new Weather[]{
                new Weather(
                        "Самара",
                        "2011-12-03T10:15:30",
                        -15.2,
                        RainfallType.SNOW,
                        756
                ),
                new Weather(
                        "Пекин",
                        "2011-12-03T10:15:30",
                        3.2,
                        RainfallType.CLEAR,
                        768
                ),
                new Weather(
                        "Лондон",
                        "2011-12-03T10:15:30",
                        10.8,
                        RainfallType.RAIN,
                        745
                )
        });
    }
}
