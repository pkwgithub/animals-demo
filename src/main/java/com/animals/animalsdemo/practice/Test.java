package com.animals.animalsdemo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List arrayList = new ArrayList();
        arrayList.add(1);
        List<Integer> list = Arrays.asList(1, 2, 4);
        list.remove(1);
        System.out.println(list);
    }
}
