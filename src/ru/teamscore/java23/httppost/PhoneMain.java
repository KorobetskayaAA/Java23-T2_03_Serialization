package ru.teamscore.java23.httppost;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Arrays;

public class PhoneMain {

    private static final String dadataFileName = "dadata.properties";
    private static final String[] phones = { "раб 846)231.60.14 *139" };

    public static void main(String[] args) throws IOException, InterruptedException {
        String phonesJson = Arrays.toString( Arrays
                .stream(phones)
                .map(p -> "\"" + p + "\"")
                .toArray()
        );
        System.out.println(phonesJson);

        DaDataProperties properties = getDaDataProperties();

        String result = postPhones(properties, phonesJson);
        System.out.println(result);

        ObjectMapper objectMapper = new ObjectMapper();
        PhoneInfo phoneInfo = objectMapper.readValue(result, PhoneInfo[].class)[0];
        System.out.println();
        System.out.println(phoneInfo);
    }

    private static String postPhones(DaDataProperties properties, String phonesJson) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(properties.getUrl()))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization",  "Token " + properties.getApiKey())
                .header("X-Secret",  properties.getSecretKey())
                .POST(HttpRequest.BodyPublishers.ofString(phonesJson))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        return body;
    }

    private static DaDataProperties getDaDataProperties() {
        try (InputStream in = new BufferedInputStream(
                new FileInputStream(Path.of("resources", dadataFileName).toFile()))) {
            ObjectMapper objectMapper = new ObjectMapper();
            DaDataProperties properties = objectMapper.readValue(in, DaDataProperties.class);
            return properties;
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
