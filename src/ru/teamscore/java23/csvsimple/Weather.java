package ru.teamscore.java23.csvsimple;

public class Weather {
    private String locationTitle;
    private String timeStamp;
    private double temperature;
    private RainfallType rainfall;
    private int airPressure;

    public Weather() {
    }

    public Weather(String locationTitle, String timeStamp, double temperature, RainfallType rainfall, int airPressure) {
        this.locationTitle = locationTitle;
        this.timeStamp = timeStamp;
        this.temperature = temperature;
        this.rainfall = rainfall;
        this.airPressure = airPressure;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public RainfallType getRainfall() {
        return rainfall;
    }

    public void setRainfall(RainfallType rainfall) {
        this.rainfall = rainfall;
    }

    public int getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(int airPressure) {
        this.airPressure = airPressure;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
