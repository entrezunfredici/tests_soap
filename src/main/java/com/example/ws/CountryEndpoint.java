package com.example.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE = "http://example.com/ws";

    private final CountryRepository repository;

    public CountryEndpoint(CountryRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(repository.findCountry(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "listCountriesRequest")
    @ResponsePayload
    public ListCountriesResponse listCountries(@RequestPayload ListCountriesRequest request) {
        ListCountriesResponse response = new ListCountriesResponse();
        response.getCountries().addAll(repository.findAllCountries());
        return response;
    }
}
