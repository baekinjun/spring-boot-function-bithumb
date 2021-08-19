package com.example.customer.methodReference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

import static java.util.Comparator.comparingInt;

public class methodReferenceTest {
    class MethodReferenceClass {
        Supplier<Date> newDate = Date::new;
        Consumer<String> print = System.out::print;
        Function<Object, String> objectToString = String::valueOf;
        //Integer.parseInt("10") -> 10
        Function<String, Integer> stringtoInteger = Integer::parseInt;
        //두개를 받았는대 큰값을 반환
        BiFunction<Integer, Integer, Integer> returnMax = Math::max;
    }

    @Test
    void listSortTest() {
        List<String> list = Arrays.asList("Apple", "Kiwi", "Orange");
        list.sort(comparingInt(String::length));
        list.forEach(System.out::println);
    }
}
