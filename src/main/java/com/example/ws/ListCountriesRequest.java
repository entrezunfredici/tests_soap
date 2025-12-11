package com.example.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "listCountriesRequest", namespace = "http://example.com/ws")
public class ListCountriesRequest {
    // Empty request body; JAXB needs a concrete type for the operation payload.
}
