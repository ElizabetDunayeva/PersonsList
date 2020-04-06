package com.company.JAXB;


import com.company.CsvLoader;
import com.company.Entities.Division;
import com.company.Entities.Person;
import com.company.factory.Factory;
import com.company.repository.MyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class JAXBmanager {

    private static Logger LOG = LoggerFactory.getLogger(JAXBmanager.class);

    public IPersonRepository read(){
        return null;
    }

    public void writeToXml(){
        LOG.debug("[ write: ]");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, Division.class, MyList.class);
            File file = new File("./file.xml");
            Factory factory = new Factory();
            IRepository<IPerson> base = factory.createRepository(IPerson.class);
            CsvLoader.parseList(base);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(base, file);
        } catch (JAXBException | IOException e) {
            LOG.error("[JAXBException| IOException: {}]", e);
            e.printStackTrace();
        }
    }
}
