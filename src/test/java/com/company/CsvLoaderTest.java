package com.company;

import com.company.factory.Factory;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CsvLoaderTest {

    @Test
    void parseList() throws IOException {
        Factory factory = new Factory();
        IRepository<IPerson> base = factory.createRepository(IPerson.class);
        CsvLoader.parseList(base);
    }
}