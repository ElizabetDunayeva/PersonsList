package com.company;

public class Factory implements ILabFactory {
    public IPerson createPerson(){
        return new Person();
    }
    public IDivision createDivision(){
        return new Division();
    }
    public <T> IRepository<T> createRepository(Class<T> clazz){
        return (IRepository) new MyList();
    }
    public IPersonRepository createPersonRepository(){
        return new MyList();
    }
}
