package com.company.repository;

import com.company.Entities.Person;
import com.company.InjectException;
import com.company.Injector;
import com.company.factory.Factory;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.math.BigDecimal;
import java.util.function.Predicate;

import static com.company.Entities.Person.comparatorbirthday;
import static com.company.Entities.Person.comparatorid;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    Person A = new Person();
    Person B = new Person();
    Person C = new Person();
    private final Factory factory = new Factory();
    private final IRepository<IPerson> list = factory.createRepository(IPerson.class);

    @BeforeEach
    public void setUp() {
        B.SetPerson(6401, "Ann", Gender.FEMALE, java.time.LocalDate.parse("1995-09-01"), BigDecimal.valueOf(3400));
        A.SetPerson(4380, "Andre", Gender.MALE, java.time.LocalDate.parse("2005-08-05"), BigDecimal.valueOf(3400));
        C.SetPerson(540,"Roman",Gender.MALE,java.time.LocalDate.parse("1990-10-12"),BigDecimal.valueOf(5200));
    }
    @Test
    void add() {
        list.add(A);
        list.add(B);
        list.add(C);
        IPerson[] actualbase = list.toList().toArray(new IPerson[0]);
        IPerson[] expectedbase = new Person[]{A,B,C};
        assertArrayEquals(actualbase,expectedbase);
    }

    @Test
    void delete() {

        list.add(A);
        list.add(B);
        list.add(C);
        list.delete(0);
        IPerson[] actualbase = list.toList().toArray(new IPerson[0]);
        IPerson[] expectedbase = new Person[]{B,C};
        assertArrayEquals(actualbase,expectedbase);

    }

    @Test
    void sortBy() throws InjectException {

        list.add(A);
        list.add(B);
        list.add(C);
        Injector.inject(list);
        list.sortBy(comparatorbirthday);
        IPerson[] expectedbase = new Person[]{C,B,A};
        IPerson[] actualbase = list.toList().toArray(new IPerson[0]);
        assertArrayEquals(actualbase,expectedbase);

    }

    @Test
    void add1() {
        list.add(A);
        list.add(B);
        list.add(1,C);
        IPerson[] expectedbase = new Person[]{A,C,B};
        IPerson[] actualbase = list.toList().toArray(new IPerson[0]);
        assertArrayEquals(actualbase,expectedbase);
    }


}