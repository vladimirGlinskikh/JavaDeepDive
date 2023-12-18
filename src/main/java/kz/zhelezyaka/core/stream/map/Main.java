package kz.zhelezyaka.core.stream.map;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        List<Integer> list1 = list.stream()
                .map(String::length)
                .collect(Collectors.toList());
        out.println(list1);

        out.println("------------------------------------------");

        int[] array = {3, 8, 9, 12};
        array = Arrays.stream(array)
                .map(e -> {
                    if (e % 2 == 0) {
                        e += 1;
                    }
                    return e;
                }).toArray();
        out.println(Arrays.toString(array));
    }
}
