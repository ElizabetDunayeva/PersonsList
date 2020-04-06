package com.company.Entities;

import com.company.JAXB.DateAdapter;

import org.joda.time.Years;

import java.time.Period;
import java.time.Year;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.enums.Gender;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Person")
public class Person implements IPerson {

    String firstname;
    String lastname;
    Gender pol;
    Integer ID;
    java.time.LocalDate birthday;
    BigDecimal salary;
    Division division;
    public static final List<IDivision> allDivision = new ArrayList<>();

    /**
     *
     * @param name name of person
     * @param pol female/male
     * @param ID int number
     * @param birthday date as YYYY-MM-DD
     */
   final public void SetPerson(final Integer ID, final String name, final Gender pol, final java.time.LocalDate birthday, final BigDecimal salary) {
        this.firstname = name;
        this.pol = pol;
        this.ID = ID;
        this.birthday = birthday;
        this.salary = salary;
    }

    public static final Comparator<IPerson> comparatorid =
           (IPerson a, IPerson b) -> (a.getId() - b.getId());
    public static final Comparator<IPerson> comparatorname =
            (IPerson a, IPerson b) -> (a.getFirstName().compareTo(b.getFirstName()));
    public static final Comparator<IPerson> comparatorbirthday =
            (IPerson a, IPerson b) -> (comparer(a,b));

   public static  int comparer(IPerson a,IPerson b){
        java.time.LocalDate a1 = a.getBirthdate();
        java.time.LocalDate b1 = b.getBirthdate();
        int rezult;
        if (a1.isBefore(b1)) {
            rezult = 1;
        }
        if(a1.isAfter((b1))){
            rezult = -1;
        }
        else rezult = 0;
        return rezult;
        }



    public String getFirstName() {
        return firstname;
    }


    public String getLastName() {
        return lastname;
    }


    public Gender getGender() {
        return pol;
    }


    public Integer getId() {
        return this.ID;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public java.time.LocalDate getBirthdate() {
        return birthday;
    }


    public void setFirstName(String Firstname) {
        this.firstname = Firstname;
    }

    public void setLastName(String Lastname) {
        this.lastname = Lastname;
    }


    public void setGender(Gender pol) {
        this.pol = pol;
    }


    public void setId(Integer ID) {
        this.ID = ID;
    }


    public void setBirthdate(java.time.LocalDate birthday) {
       this. birthday = birthday;
    }
    /** function
     * function for getting age from date of birthday
     * @return age as int number
     */
    public Integer getAge() {

        LocalDate current = LocalDate.now();
        Period period = Period.between(this.birthday,current);
        int age = period.getYears();

        return age;
    }
    public BigDecimal getSalary(){
        return salary;

    }
    public void setSalary( BigDecimal salary){
        this.salary = salary;

    }
    @XmlElement(type = Division.class)
    public IDivision getDivision(){

        return division;

    }

    public void setDivision(IDivision division){
       this.division =(Division)division;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return  (ID == person.ID
                && firstname.equals(person.firstname)
                 && pol.equals(person.pol)
                 && birthday.equals(person.birthday));

    }
    @Override
   public  String toString(){
        return this.ID.toString()+ " \n" + this.firstname.toString() + "\n" + this.getAge().toString();
   }




}
