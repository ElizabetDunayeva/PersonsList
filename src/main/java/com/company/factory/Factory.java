package com.company.factory;

import com.company.Entities.Division;
import com.company.Entities.Person;
import com.company.InjectException;
import com.company.Injector;
import com.company.repository.MyList;
import ru.vsu.lab.factory.*;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;


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

    public <T> IRepository createRepository(Class<T> clazz){

       /* MyList<T> list = new MyList<T>();
        try {
            Injector.inject(list);
        }catch(InjectException e){}*/
        return new MyList() ;
    }

    public IPersonRepository createPersonRepository(){
        return null;
    }
}
