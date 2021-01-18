package com.company;

import java.util.*;
import java.util.stream.Collectors;
import static com.company.Sex.MAN;
import static com.company.Sex.WOMAN;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //1
        System.out.println("number of underage people");
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(count + "\n");
        //2
        System.out.println("the list of recruits");
        persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 27 && person.getSex() == MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("\n");
        //3
        System.out.println("the list of working people");
        persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .filter(person -> person.getSex() == WOMAN)
                .map(Person::getFamily)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 65)
                .filter(person -> person.getSex() == MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
