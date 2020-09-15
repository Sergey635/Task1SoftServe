package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        
	    FullTimeEmployee ivanov = new FullTimeEmployee("Ivanov",1277.3);
	    FullTimeEmployee petrov = new FullTimeEmployee("Petrov",1923.3);
	    FullTimeEmployee sidorov = new FullTimeEmployee("Sidorov",5277.3);

        List<FullTimeEmployee> list = Stream.of(ivanov,petrov,sidorov).collect(Collectors.toList());

        double summa = list.stream().mapToDouble(item -> item.getSalary()).sum();
        System.out.println(summa);

    }
}
