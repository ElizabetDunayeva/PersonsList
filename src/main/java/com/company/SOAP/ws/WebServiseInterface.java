package com.company.SOAP.ws;

import ru.vsu.lab.entities.IPerson;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
//говорим,что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiseInterface {

    @WebMethod
    public String getUserNameById(int id);

    @WebMethod
    public long getCountUsersByAge(Integer age);

}