package ru.teamscore.java23.httppost;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.lang.String;

public class DaDataProperties implements Serializable {
  @JsonProperty("API_KEY")
  private String API_KEY;

  @JsonProperty("SECRET_KEY")
  private String SECRET_KEY;

  private String url;

  public String getApiKey() {
    return this.API_KEY;
  }

  public void setApiKey(String API_KEY) {
    this.API_KEY = API_KEY;
  }

  public String getSecretKey() {
    return this.SECRET_KEY;
  }

  public void setSecretKey(String SECRET_KEY) {
    this.SECRET_KEY = SECRET_KEY;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
