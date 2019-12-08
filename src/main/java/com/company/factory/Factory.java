package com.company.factory;

import com.company.Entities.Division;
import com.company.Entities.IDivision;
import com.company.Entities.IPerson;
import com.company.Entities.Person;
import com.company.repository.IPersonRepository;
import com.company.repository.IRepository;
import com.company.repository.MyList;

public class Factory implements ILabFactory {
    private String factory_name;

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }


    public IPerson createPerson(){

        return new Person();
    }
    public IDivision createDivision(){

        return new Division();
    }
    public <T> IRepository<T> createRepository(Class<T> clazz){

        return new MyList<T>();
    }
    public IPersonRepository createPersonRepository(){
        return null;
    }
}
