package ru.teamscore.java23.httpget;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class SunriseMain {
    static String path = "https://api.sunrisesunset.io/json";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        double lat = Double.parseDouble(args[0]);
        double lng = Double.parseDouble(args[1]);

        URI uri = new URI(path + String.format(Locale.US, "?lng=%f&lat=%f", lng, lat));
        System.out.println("Requesting " + uri);
        String result = getByHttp(uri);
        SunriseWrapper sunrise = getSunriseFromJson(result);
        System.out.println();
        System.out.println(sunrise.getSunrise());
    }

    private static String getByHttp(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder(uri)
                .build();
        HttpClient client = HttpClient
                .newBuilder()
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode() );
        String body = response.body();
        System.out.println(body);
        return body;
    }

    private static SunriseWrapper getSunriseFromJson(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        SunriseWrapper sunrise = mapper
                .reader(SunriseWrapper.class)
                .readValue(body);
        return sunrise;
    }
}
