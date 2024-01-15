package ru.teamscore.java23.httpget;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SunriseWrapper {
    @JsonProperty("results")
    Sunrise sunrise;

    public Sunrise getSunrise() {
        return sunrise;
    }

    public void setSunrise(Sunrise sunrise) {
        this.sunrise = sunrise;
    }
}
