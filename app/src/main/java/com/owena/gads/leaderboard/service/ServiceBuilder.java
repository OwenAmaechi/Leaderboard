package com.owena.gads.leaderboard.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

  private static final String URL = "https://gadsapi.herokuapp.com/api/";

  private static Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(URL)
      .addConverterFactory(GsonConverterFactory.create());

  private static Retrofit sRetrofit = sBuilder.build();

  public static <S> S buildService(Class<S> serviceType){
    return sRetrofit.create(serviceType);
  }
}
