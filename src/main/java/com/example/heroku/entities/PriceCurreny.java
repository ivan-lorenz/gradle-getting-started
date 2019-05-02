package com.example.heroku.entities;

public class PriceCurreny {
    public static String convertToEuros(double price) {
        return String.format("€%.2f", price);
    }
}
