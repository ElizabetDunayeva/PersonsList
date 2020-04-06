package com.company.sort;

import com.company.repository.MyList;

import java.util.Comparator;

/**
 * нтерфейс для сортировки
 * @param <T> параметр типизации
 */
public interface ISort<T> {

    void sort(MyList<T> list, Comparator<T> comparator);
}
