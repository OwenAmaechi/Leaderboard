package com.owena.gads.leaderboard.model;

public class IQ {

  private String name;
  private String country;
  private int score;
  private String badgeUrl;

  public IQ(String name, String country, int score, String badgeUrl) {
    this.name = name;
    this.country = country;
    this.score = score;
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

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getBadgeUrl() {
    return badgeUrl;
  }

  public void setBadgeUrl(String badgeUrl) {
    this.badgeUrl = badgeUrl;
  }

  @Override
  public String toString() {
    return "IQ{" +
               "name='" + name + '\'' +
               ", country='" + country + '\'' +
               ", score=" + score +
               ", badgeUrl='" + badgeUrl + '\'' +
               '}';
  }
}
