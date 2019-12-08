package com.company.Entities;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Person implements IPerson {

    String firstname;
    String lastname;
    Gender pol;
    Integer ID;
    LocalDate birthday;
    BigDecimal salary;
    IDivision division;
    public static final List<IDivision> allDivision = new ArrayList<>();

    /**
     *
     * @param name name of person
     * @param pol female/male
     * @param ID int number
     * @param birthday date as YYYY-MM-DD
     */
   final public void SetPerson(final Integer ID,final String name, final Gender pol, final  LocalDate birthday,final BigDecimal salary) {
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
        LocalDate a1 = a.getBirthdate();
        LocalDate b1 = b.getBirthdate();
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


    public LocalDate getBirthdate() {
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


    public void setBirthdate(LocalDate birthday) {
       this. birthday = birthday;
    }
    /** function
     * function for getting age from date of birthday
     * @return age as int number
     */
    public Integer getAge() {
        LocalDate current = new LocalDate();
        Years age = Years.yearsBetween(birthday, current);
        return age.getYears();
    }
    public BigDecimal getSalary(){
        return salary;

    }
    public void setSalary( BigDecimal salary){
        this.salary = salary;

    }

    public IDivision getDivision(){

        division.ToString();
        return division;

    }

    public void setDivision(IDivision division){
       this.division = division;

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
