package com.company.factory;
import java.io.File;

public class FactoryResolver {
    public Factory createFactory(File file){
        Factory factory = new Factory();
        factory.setFactory_name(file.getName());

        return factory;
    }
}
