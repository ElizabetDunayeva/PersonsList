package com.company;

import java.util.Comparator;

public class Sort <T>{
    static public void  bublesort(Comparator<IPerson>comparator, MyList list){
        int count = list.getCount();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < count; i++) {
                if (comparator.compare(list.get(i),list.get(i-1)) >=0) {
                    IPerson tmp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i-1,tmp);
                    needIteration = true;
                }
            }
        }


    }

   static public void vstavkasort(Comparator<IPerson>comparator, MyList list){
        for (int left = 0; left < list.getCount(); left++) {
            int minInd = left;
            for (int i = left; i < list.getCount(); i++) {
                if (comparator.compare(list.get(i),list.get(minInd)) >=0) {
                    minInd = i;
                }
            }
            IPerson tmp = list.get(left);
            list.set(left, list.get(minInd));
            list.set(minInd,tmp);

        }


    }

}
