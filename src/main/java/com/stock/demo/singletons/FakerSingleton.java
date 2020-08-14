package com.stock.demo.singletons;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerSingleton {

    private static Faker faker;

    public static Faker getInstance() {

        return faker == null ? faker = new Faker(new Locale("pt-BR")) : faker;
    }
}
