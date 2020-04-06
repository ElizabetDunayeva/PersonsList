package com.company.SOAP.client;

//чтобы получить wsdl описание
import java.net.URL;

import java.net.MalformedURLException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.company.SOAP.ws.WebServiseInterface;


public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException{

        URL url = new URL("http://localhost:1986/wss/persons?wsdl");

        QName qname = new QName("http://ws.SOAP.company.com/","WebServiceImplService");

        Service service = Service.create(url,qname);

        WebServiseInterface webserv = service.getPort(WebServiseInterface.class);

        System.out.println(webserv.getUserNameById(1));
        System.out.println(webserv.getCountUsersByAge(20));

    }
}
