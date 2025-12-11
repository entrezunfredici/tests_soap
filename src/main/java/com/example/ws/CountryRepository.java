package com.example.ws;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CountryRepository {

    private final Map<String, String> countries = new ConcurrentHashMap<>();

    public CountryRepository() {
        // Demo data
        countries.put("France", "France");
        countries.put("Spain", "Spain");
        countries.put("United Kingdom", "United Kingdom");
        countries.put("Germany", "Germany");
    }

    public String findCountry(String name) {
        return countries.getOrDefault(name, "Unknown");
    }
}
