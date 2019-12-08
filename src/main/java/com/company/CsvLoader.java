package com.company;


import com.company.Entities.Gender;
import com.company.Entities.IDivision;
import com.company.Entities.Person;
import com.company.Entities.IPerson;

import com.company.factory.Factory;
import com.company.repository.IRepository;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import  org.joda.time.format.DateTimeFormatter;



public class CsvLoader {

    private static final Factory factory = new Factory();

    static void parseList(final IRepository base) throws IOException {
        final CSVReader reader = new CSVReader(new FileReader("C:\\persons.csv"),';','"',1);
        String[] nextLine;
        while((nextLine = reader.readNext())!= null){
            int id;
            String firstName;
            Gender gender;
            LocalDate date;
            IDivision division;
            BigDecimal salary;
           // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
           DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
            id = Integer.parseInt(nextLine[0]);
            firstName = nextLine[1];
            if(nextLine[2].compareTo("Male")>0){
                gender = Gender.MALE;

            }else {
                gender = Gender.FEMALE;
            }
            date =  LocalDate.parse(nextLine[3],formatter);
            salary = new  BigDecimal(nextLine[5]);
            division = checkArrayDivision(nextLine[4]);
            Person person = new Person();
            person.SetPerson(id,firstName,gender,date,salary);
            base.add(person);
        }
    }
    static private IDivision checkArrayDivision(String divisionName){
        for( IDivision currentDivision : Person.allDivision) {
            if(currentDivision.getName().equals(divisionName)){
                return currentDivision;
            }

        }
        IDivision newDivision = factory.createDivision();
        newDivision.setName(divisionName);
        newDivision.setId(Person.allDivision.size() + 1);
        Person.allDivision.add(newDivision);
        return newDivision;
    }
}
