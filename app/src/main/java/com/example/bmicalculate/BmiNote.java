package com.example.bmicalculate;

public enum BmiNote {
    NORMA("Twoja waga jest prawidłowa"),
    NIEDOWAGA("Masz niedowagę. Skonsultuj się z dietetykiem"),

    NADWAGA("Masz nadwagę. Zalecana większa aktywność fizyczna"),

    OTYŁOŚĆ("Otyłość. Wskazana konsultacja lekarska");

    private final String description;

    BmiNote(String description){this.description = description;}

    public String getDescription(){return description;}
}
