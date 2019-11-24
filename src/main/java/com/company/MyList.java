package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * class for storaging information about persons
  *  massiv Persons
  * count - number of Persons
 */
public class MyList<T> implements IRepository<IPerson>,IPersonRepository {
    private IPerson[] Persons;
    private int count;


    public IPerson[] getPersons() {

        return Persons;
    }
    public int getCount(){
        return count;
    }

    /**
     * Constructer, create list with length =1
     */
    public MyList() {

     Persons = new IPerson[1];
     this.count = 0;

    }

    /**
     *
     * @param id identification value  about person by which we search him
     * @return person with set ID = id
     */
    public IPerson getin( int id)   {
        int k = 0;
        for (int i = 0; i < count; i++) {
            if (Persons[i].getId() == id) {
                k += i + 1;
            }
        }
        if (k == 0) {
            throw new IllegalArgumentException("Такого обьекта нет!");
        }
       // System.out.println("Информация по запрошенному индекcу"+"  "+id);
        getPersonsDataindex(k - 1);
        return Persons[k - 1];
    }

    public IPerson get(int i) {
        return Persons[i];
    }
    /**
     * shows all information about all persons in the list
     */
    public void getPersonsData() {
        for (int i = 0; i < count; i++) {

            System.out.println(Persons[i].getId());
            System.out.println(Persons[i].getFirstName());
            System.out.println(Persons[i].getGender());
            System.out.println(Persons[i].getAge());
            System.out.println("-----------------------------------------------");
                    }


    }

    /**
     * shows all information about person with index i
     * @param i is index person in the massiv
     */
    public void getPersonsDataindex(int i) {

           if (i > count + 1) {
               throw new IllegalArgumentException("Такого обьекта нет!");
           }
            System.out.println(Persons[i].getId());
            System.out.println(Persons[i].getFirstName());
            System.out.println(Persons[i].getGender());
            System.out.println(Persons[i].getAge());
            System.out.println(Persons[i].getBirthdate());
            System.out.println("-----------------------------------------------");



    }

    /**
     * Add new person to a list,extends length of list into 2 times
     * @param p1 person which need to be added
     * @return new list  with added person
     */
    public void add(IPerson p1) {


        int col = Persons.length;
        count++;
        if (count > Persons.length) {
            IPerson newPersons[] = new IPerson[2 * col];
            System.arraycopy(Persons, 0, newPersons, 0, Persons.length);
            newPersons[count - 1] = p1;
            Persons = newPersons;


        } else {
            Persons[count - 1] = p1;


        }


    }

    /**
     * delete person with a set  identification value and throws exception if there is not such a person with ID=id
     * @param id identification value of person (ID)
     * @return new list of persons without person with ID = id
     */
    public IPerson delete(int id) {
        int k = 0;
        for (int i = 0;i < count; i++) {
            if (Persons[i].getId() == id) {
                k += i + 1;
            }
        }
        if (k == 0) {
            throw new IllegalArgumentException("Такого обьекта нет!");
        }
        int col = Persons.length;
        count--;
        Person newPersons[] = new Person[col];
        System.arraycopy(Persons, 0, newPersons, 0, k - 1);
        System.arraycopy(Persons, k, newPersons,  k - 1, Persons.length - k);
        Persons = newPersons;



      return Persons[k - 1];


    }

    /**
     * sort by method puzirka. from bigger to smaller
     * @param comp defines field on what would be list sorted
     */
     public void sortBy(Comparator<IPerson> comp){
         Sort.bublesort(comp,this);

     }



    //public IPerson set(int index, IPerson person);

     public void add(int index, IPerson person){

         int col = Persons.length;
         count++;
         if (count > Persons.length) {
             IPerson newPersons[] = new IPerson[2 * col];
             System.arraycopy(Persons, 0, newPersons, index-1, index);
             newPersons[index] = person;
             System.arraycopy(Persons, index, newPersons, index+1, Persons.length-index);
             Persons = newPersons;


         } else {
             IPerson newPersons[] = new IPerson[Persons.length];
             System.arraycopy(Persons, 0, newPersons, index-1, index);
             newPersons[index] = person;
             System.arraycopy(Persons, index, newPersons, index+1, Persons.length-index);
             Persons = newPersons;


         }

     }
    public List<IPerson> toList(){
        ArrayList<IPerson> list = new ArrayList<IPerson>();
        for(int i =0;i<count;i++)
            list.add(Persons[i]);
        return list;
    }

    public IPerson set(int index, IPerson person){
        IPerson temp = Persons[index];
        Persons[index] = person;
        return temp ;
    }
    public IRepository searchBy(Predicate<IPerson> predicate){
        MyList res = new MyList();
        for (IPerson val : Persons) {
            if (predicate.test(val))
                res.add(val);
        }
        return res;
    }
}
