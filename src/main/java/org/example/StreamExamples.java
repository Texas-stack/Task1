package org.example;

import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class StreamExamples {

    public List<Integer> filterAndSortEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> toUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public int sumArrayElements(int[] array) {
        return Arrays.stream(array).sum();
    }

    public Map<Integer, Double> groupByAgeAndCalculateAverage(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.averagingInt(Person::getAge)));
    }

    public Optional<String> filterByLengthAndFindFirst(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 5)
                .findFirst();
    }

    public List<Integer> filterAndSortEvenNumbersParallel(List<Integer> numbers) {
        return numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    public void readFileAndFilterLines(String filePath, String condition) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.filter(line -> line.contains(condition))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> filterStreamWithConversion(Stream<?> stream, Class<T> type) {
        return stream.filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    // Вложенный класс Person
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
