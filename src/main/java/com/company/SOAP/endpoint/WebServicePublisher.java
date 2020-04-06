package com.company.SOAP.endpoint;

//класс для запуска веб-сервера с веб-сервисами
import javax.xml.ws.Endpoint;

import com.company.SOAP.ws.WebServiceImpl;

import java.io.IOException;


public class WebServicePublisher {

    public static void main(String[] args) throws IOException {
        Endpoint.publish("http://localhost:1986/wss/persons", new WebServiceImpl());

    }
}
