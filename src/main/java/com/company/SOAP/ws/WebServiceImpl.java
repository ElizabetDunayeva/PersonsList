package com.company.SOAP.ws;

import com.company.CsvLoader;
import com.company.Entities.Person;
import com.company.factory.Factory;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import javax.jws.WebService;
import java.io.IOException;

@WebService(endpointInterface = "com.company.SOAP.ws.WebServiseInterface")
public class WebServiceImpl implements WebServiseInterface {

    public IRepository<IPerson> list;

    public WebServiceImpl() throws IOException {
        Factory factory = new Factory();
        this.list = factory.createRepository(IPerson.class);
        CsvLoader.parseList(list);

    }

    @Override
    public String getUserNameById(int id){
        Person person =(Person) list.get(id);
        return person.getFirstName();

    }
    @Override
    public long getCountUsersByAge(Integer age){
        list.toList();
        return list.toList().stream().filter(x->x.getAge()>25).count();
    }
}
