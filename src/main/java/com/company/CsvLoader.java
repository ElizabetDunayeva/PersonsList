package com.company;


import com.company.Entities.Person;

import com.company.factory.Factory;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;


public class CsvLoader {
    private static final Logger LOG = LoggerFactory.getLogger(CsvLoader.class);

    private static final Factory factory = new Factory();

   public static void parseList(final IRepository base) throws IOException {

        LOG.debug("[ parseBase:{}]",base);
        final CSVReader reader = new CSVReader(new FileReader("C:\\persons.csv"),';','"',1);
        String[] nextLine;
        while((nextLine = reader.readNext())!= null){
            int id;
            String firstName;
            Gender gender;
            java.time.LocalDate date;
            IDivision division;
            BigDecimal salary;
           // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            //DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
            id = Integer.parseInt(nextLine[0]);
            firstName = nextLine[1];
            if(nextLine[2].compareTo("Male")>0){
                gender = Gender.MALE;

            }else {
                gender = Gender.FEMALE;
            }
            date =  java.time.LocalDate.parse(nextLine[3],formatter);
            salary = new  BigDecimal(nextLine[5]);
            division = checkArrayDivision(nextLine[4]);
            Person person = new Person();
            person.SetPerson(id,firstName,gender,date,salary);
            base.add( person);
        }
    }
    static private IDivision checkArrayDivision(String divisionName){
        LOG.debug("[checkArrayDivision: {}", divisionName);
        for( IDivision currentDivision : Person.allDivision) {
            if(currentDivision.getName().equals(divisionName)){
                LOG.debug("] return : {}", currentDivision);
                return currentDivision;
            }

        }
        IDivision newDivision = factory.createDivision();
        newDivision.setName(divisionName);
        newDivision.setId(Person.allDivision.size() + 1);
        Person.allDivision.add(newDivision);
        LOG.debug("]return : {}", newDivision);
        return newDivision;
    }
}
