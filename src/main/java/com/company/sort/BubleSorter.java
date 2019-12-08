package com.company.sort;


import com.company.repository.MyList;

import java.util.Comparator;

public class BubleSorter <T>implements ISort<T> {
     public void  sort(MyList<T> list, Comparator<T>comparator){
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
