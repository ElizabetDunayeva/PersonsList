package com.company;
import com.company.sort.ISort;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Injector<T> {

    public static <T> T inject(T rep) throws InjectException {
        String Path = "src\\main\\resources\\prop.properties";
        Class<?> clazz = rep.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(Path));
        } catch (IOException e) {
            throw new InjectException(e);
        }
        for (Field field : fields) {
            System.out.println(field.getClass().getName());
            if (field.isAnnotationPresent(LabInject.class)) {
                try {
                    Class<?> seatedClass = Class.forName(prop.getProperty("sortType"));
                    Object seatedClassObject = seatedClass.newInstance();
                    field.setAccessible(true);
                    field.set(rep, seatedClassObject);
                } catch (IllegalAccessException e) {
                    throw new InjectException(e);
                } catch (ClassNotFoundException e) {
                    throw new InjectException(e);
                }
                catch(InstantiationException e){
                    throw new InjectException(e);
                }

            }


        }
        return rep;
    }
}
