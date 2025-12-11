package com.example.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "listCountriesResponse", namespace = "http://example.com/ws")
public class ListCountriesResponse {

    @XmlElement(name = "country", namespace = "http://example.com/ws")
    private final List<String> countries = new ArrayList<>();

    public List<String> getCountries() {
        return countries;
    }
}
