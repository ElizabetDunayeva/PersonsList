package com.company.sort;


import com.company.repository.MyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;

@XmlRootElement
public class BubleSorter <T>implements ISort<T> {

    public final static Logger LOG = LoggerFactory.getLogger(BubleSorter.class);


     public void  sort(MyList<T> list, Comparator<T>comparator){
         LOG.debug("[ sort BubleSorter: {} {}]",list, comparator);
        int count = list.getCount();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < count; i++) {
                if (comparator.compare(list.get(i),list.get(i-1)) >=0) {
                    T tmp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i-1,tmp);
                    needIteration = true;
                }
            }
        }


    }


}
