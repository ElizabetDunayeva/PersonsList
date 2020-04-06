package com.company;

import com.company.repository.MyList;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.entities.IPerson;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyStreamTest {

    @Test
    public void stream() throws IOException {
        MyList base = new MyList();
        MyStream<IPerson> streamApi = new MyStream<>(base);
        streamApi.firstzapros();
        streamApi.seconddzapros();
        streamApi.thirdzapros();
    }

}