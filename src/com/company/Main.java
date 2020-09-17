package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        FullTimeEmployee ivanov = new FullTimeEmployee("Ivanov", 1277.3);
        FullTimeEmployee petrov = new FullTimeEmployee("Petrov", 1923.3);
        FullTimeEmployee sidorov = new FullTimeEmployee("Sidorov", 5277.3);

        List<FullTimeEmployee> fullTimeEmployeeList = Stream.of(ivanov, petrov, sidorov).collect(Collectors.toList());

        double summa = fullTimeEmployeeList.stream().mapToDouble(item -> item.getSalary()).sum();
        System.out.println(summa);

        EmployeePartTime devops = new EmployeePartTime("Devops", 12, 32);
        EmployeePartTime backEndDev = new EmployeePartTime("BackEndDev", 35, 176);
        EmployeePartTime frontEndDev = new EmployeePartTime("FrontEndDev", 25, 85);
        EmployeePartTime design = new EmployeePartTime("Design", 50, 30);
        EmployeePartTime tester = new EmployeePartTime("Tester", 20, 176);

        List<EmployeePartTime> partTimeList = Stream.of(devops, backEndDev, frontEndDev, design, tester)
                .collect(Collectors.toList());

        double partTimeTotlSalary = 0;
        for (EmployeePartTime item : partTimeList) {
            partTimeTotlSalary += item.getHours() * item.getRate();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println(partTimeTotlSalary + " Z/P part time employees");

        double total = summa + partTimeTotlSalary;
        System.out.println(total);
        System.out.println("---------------------------------------------------------------");
//поліморфізм. створюєм інтерфейс

        List<IAccounting> totalList = new ArrayList<>(
                Arrays.asList(ivanov,petrov, sidorov, devops, backEndDev, frontEndDev, design, tester));
  /*      totalList.add(ivanov);
        totalList.add(petrov);
        totalList.add(sidorov);
        totalList.add(devops);
        totalList.add(backEndDev);
        totalList.add(frontEndDev);
        totalList.add(design);
        totalList.add(tester);
*/
        double totalSalary = totalList.stream().mapToDouble(item -> item.getMontsSalary()).sum();

        System.out.println(totalSalary);

        IAccounting patheticLoser = totalList.stream().min(Comparator.comparing(IAccounting::getMontsSalary))
                .orElse(null);

        System.out.println(patheticLoser + " neuda4nik");

        IAccounting nerdy = totalList.stream().max(Comparator.comparing(IAccounting::getMontsSalary))
                .orElse(null);

        System.out.println(nerdy + " Zadrot");

    }
}
