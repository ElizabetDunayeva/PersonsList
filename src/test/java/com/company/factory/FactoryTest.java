package com.company.factory;

import com.company.Entities.Person;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.repository.IRepository;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void createRepository() {
        Factory factory = new Factory();
        IRepository list = factory.createRepository(Person.class);
    }
}