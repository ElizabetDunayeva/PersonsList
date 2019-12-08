package com.company;

import com.company.Entities.IDivision;
import com.company.Entities.IPerson;
import com.company.repository.IRepository;
import org.supercsv.cellprocessor.Collector;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream <T extends IPerson>{

    private List<T> plist;

    public MyStream(IRepository rep) throws IOException {
        CsvLoader.parseList(rep);
        this.plist = rep.toList();

    }
    public Map<? extends IDivision, Long> firstzapros (){
     Stream<T> personstream = plist.stream();
     return personstream.collect(Collectors.groupingBy(
             IPerson::getDivision,Collectors.summingLong(
                     per ->per.getSalary().intValueExact())));
    }
    public List<T> seconddzapros (){
        Stream<T> personstream = plist.stream();
        return  personstream.filter(per->per.getFirstName().substring(0,1).equals("A")&&per.getSalary().intValueExact()>3000 && per.getAge()>30).collect(Collectors.toList());
    }


    public List<T> thirdzapros (){
        Stream<T> personstream = plist.stream();
        return  personstream.filter(per->per.getFirstName().substring(0,2).equals("aa")).collect(Collectors.toList());
    }







}
