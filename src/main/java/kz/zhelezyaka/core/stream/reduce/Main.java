package kz.zhelezyaka.core.stream.reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(2);

        List<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Two");
        list1.add("Three");

        Optional<Integer> resultOptional = list.stream()
                .reduce((accumulate, element) ->
                        accumulate * element);
        if (resultOptional.isPresent()) {
            out.println(resultOptional.get());
        } else {
            out.println("Result is not present");
        }

        out.println("_______________________________________");

        int result = list.stream()
                .reduce(1, (accumulator, element) -> accumulator * element);
        out.println(result);

        out.println("_________________________________________");

        Optional<String> resultOptionalList = list1.stream()
                .reduce((accumulate, element) ->
                        accumulate + " | " + element);
        if (resultOptionalList.isPresent()) {
            out.println(resultOptionalList.get());
        } else {
            out.println("Result is not present");
        }
    }
}
