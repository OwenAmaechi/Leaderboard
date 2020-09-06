package com.owena.gads.leaderboard.model;

public class Learner {
  private String name;
  private String country;
  private int hours;
  private String badgeUrl;

  public Learner(String name,int hours, String country, String badgeUrl) {
    this.name = name;
    this.country = country;
    this.hours = hours;
    this.badgeUrl = badgeUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public String getBadgeUrl() {
    return badgeUrl;
  }

  public void setBadgeUrl(String badgeUrl) {
    this.badgeUrl = badgeUrl;
  }

  @Override
  public String toString() {
    return "Learner{" +
               "name='" + name + '\'' +
               ", country='" + country + '\'' +
               ", hours=" + hours +
               ", badgeUrl='" + badgeUrl + '\'' +
               '}';
  }
}
