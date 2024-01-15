package ru.teamscore.java23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

public class JsonMain {


    public static void main(String[] args) {
        User user = getTestUser();
        // Создаем объект для (де)сериализации
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        String json = "";
        try {
            json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            System.err.println("Не удалось сериализовать пользователя в JSON: " + e.getMessage());
        }

        System.out.println();
        try {
            User userCopy = objectMapper.readValue(json, User.class);
            System.out.println(userCopy);
        } catch (JsonProcessingException e) {
            System.err.println("Не удалось десериализовать пользователя из JSON: " + e.getMessage());
        }
    }

    private static User getTestUser() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setFirstName("Илья");
        user.setLastName("Муромец");
        user.setUserName("ilyusha");
        user.setBirthDate(LocalDate.of(1143, Month.DECEMBER, 19));
        user.setToken("some token");
        user.setBanned(false);
        user.addPost(new Post(user, user.getBirthDate().plusYears(33).atStartOfDay(),
                "Встал с печи, вошел в чат"));
        user.addPost(new Post(user, user.getBirthDate().plusYears(33).plusDays(100).atTime(12, 0),
                "Соловей Разбойник снова промышляет на дорогах"));
        user.addPost(new Post(user, LocalDateTime.now().minusHours(1),
                "У Горыныча закончились головы"));
        user.addPost(new Post(user, LocalDateTime.now(),
                "Богатырский конь устал."));
        return user;
    }
}
