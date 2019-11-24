package com.company;

import org.joda.time.LocalDate;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class CsvLoader {

    private static final Factory factory = new Factory();

    static void parseList(final IRepository base) throws IOException {
        final CSVReader reader = new CSVReader(new FileReader("C:\\persons.csv"),';','"',1);
        String[] nextLine;
        while((nextLine = reader.readNext())!= null){
            int id;
            String firstName;
            String lastName;
            Gender gender;
            LocalDate date;
            IDivision division;
            BigDecimal salary;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
            id = Integer.parseInt(nextLine[0]);
            firstName = nextLine[1];
            lastName = nextLine[1];
            if(nextLine[2].compareTo("Male")>0){
                gender = Gender.MALE;

            }else {
                gender = Gender.FEMALE;
            }
            division = checkArrayDivision(nextLine[4]);
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
