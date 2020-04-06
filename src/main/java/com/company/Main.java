package com.company;
import com.company.Entities.Division;
import com.company.Entities.Person;
import com.company.JAXB.JAXBmanager;
import com.company.repository.MyList;
import org.joda.time.LocalDate;
import ru.vsu.lab.entities.enums.Gender;


import java.io.IOException;

import java.math.BigDecimal;



public class Main {

    public static void main(String[] args) throws IOException {


    	Person A = new Person();
    	Person B = new Person();
    	Person C = new Person();
    	A.SetPerson(12365,"Elizabet", Gender.FEMALE,java.time.LocalDate.parse("2000-08-05"), BigDecimal.valueOf(3400));
    	B.SetPerson(4380,"Ann", Gender.FEMALE,java.time.LocalDate.parse("1995-09-01"), BigDecimal.valueOf(3400));
		C.SetPerson(6401,"Andre", Gender.MALE,java.time.LocalDate.parse("2005-08-05"), BigDecimal.valueOf(3400));
	//Person A = new Person(12365,"Elizabet", Gender.FEMALE,"2000-08-05", BigDecimal.valueOf(3400));
	//Person B = new Person(4380,"Ann", Gender.FEMALE,"1995-09-01", BigDecimal.valueOf(3400));
	//Person C  = new Person(6401,"Andre", Gender.MALE,"2005-08-05", BigDecimal.valueOf(3400));
	MyList List1 = new MyList();
	List1.add(A);
	List1.add(B);
	List1.add(C);
	List1.getPersonsData();
	//List1.get(4789);

	System.out.println("Сортировка");
	List1.sortBy(Person.comparatorid);
	List1.getPersonsData();


	Division div1 = new Division();
	div1.setId(123);
	div1.setName("GG");
	//A.setDivision(div1);
	//A.getDivision();
	JAXBmanager manager = new JAXBmanager();
	manager.writeToXml();
	//MyList list2 = new MyList();
		/*Factory factory = new Factory();
		IRepository<IPerson> list =  factory.createRepository(IPerson.class );
	CsvLoader.parseList(list);
	MyList<IPerson>base = (MyList<IPerson>)list;
	base.getPersonsData();*/








    }
}
