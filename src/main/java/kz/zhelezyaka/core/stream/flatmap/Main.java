package kz.zhelezyaka.core.stream.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "orange"),
                Arrays.asList("banana", "kiwi"),
                Arrays.asList("lemon", "grape")
        );

        List<String> words = Arrays.asList("Stream", "flatMap");

        List<String> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        out.println(flattenedList);
        out.println("_________________________________________");

        List<String> letters = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());
        out.println(letters);
    }
}
