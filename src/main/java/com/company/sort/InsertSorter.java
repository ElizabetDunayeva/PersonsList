package com.company.sort;

import com.company.repository.MyList;

import java.util.Comparator;

public class InsertSorter<T> implements ISort<T> {



    public void sort(final MyList<T> list, final Comparator<T> comparator) {
        for (int left = 0; left < list.getCount(); left++) {
            int minInd = left;
            for (int i = left; i < list.getCount(); i++) {
                if (comparator.compare(list.get(i), list.get(minInd)) >= 0) {
                    minInd = i;
                }
            }
            T tmp = list.get(left);
            list.set(left, list.get(minInd));
            list.set(minInd, tmp);

        }
    }
}





