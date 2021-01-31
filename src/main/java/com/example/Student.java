package com.example;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private LinkedHashMap<String,String> favoriteLanguages;
    private String[] operatingSystems;

    public Student(){
        //populate favorite languages options: used language name
        favoriteLanguages = new LinkedHashMap<>();
        favoriteLanguages.put("Java","Java");
        favoriteLanguages.put("C#","C#");
        favoriteLanguages.put("PHP","PHP");
        favoriteLanguages.put("Ruby","Ruby");
        favoriteLanguages.put("Go","Go");
        //populate country options: used ISO country code
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public LinkedHashMap<String, String> getFavoriteLanguages() {
        return favoriteLanguages;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguages.get(favoriteLanguage);
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}