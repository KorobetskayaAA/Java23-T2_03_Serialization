package ru.teamscore.java23.httppost;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class PhoneInfo implements Serializable {
  private String country;

  private String extension;

  private String city;

  private String timezone;

  private String city_code;

  private String source;

  private String type;

  private String country_code;

  private String number;

  private Integer qc;

  private Integer qc_conflict;

  private String phone;

  private String provider;

  private String region;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(phone + "\n");
    sb.append(type + "\n");
    sb.append(country + ", " + region);
    if (city != null) {
      sb.append(", " + city);
    }
    sb.append("\n");
    if (provider != null) {
      sb.append(provider);
    }
    sb.append("\n");
    return sb.toString();
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getExtension() {
    return this.extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTimezone() {
    return this.timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getCity_code() {
    return this.city_code;
  }

  public void setCity_code(String city_code) {
    this.city_code = city_code;
  }

  public String getSource() {
    return this.source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCountry_code() {
    return this.country_code;
  }

  public void setCountry_code(String country_code) {
    this.country_code = country_code;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Integer getQc() {
    return this.qc;
  }

  public void setQc(Integer qc) {
    this.qc = qc;
  }

  public Integer getQc_conflict() {
    return this.qc_conflict;
  }

  public void setQc_conflict(Integer qc_conflict) {
    this.qc_conflict = qc_conflict;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getProvider() {
    return this.provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getRegion() {
    return this.region;
  }

  public void setRegion(String region) {
    this.region = region;
  }
}
