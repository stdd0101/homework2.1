package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Integer[] array = new Integer[intList.size()];
        intList.toArray(array);
        List<Integer> sortedList = new ArrayList<>();
        for(int i = 0; i< array.length; i++) {
            if(array[i] > 0 && array[i] % 2 == 0) {
                sortedList.add(array[i]);
            }
        }
        Collections.sort(sortedList);
        System.out.println(sortedList);
    }
}
