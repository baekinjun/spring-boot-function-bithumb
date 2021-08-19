package com.example.customer.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class MyPredicateTest {


    @Test
    void test1() {
        List<String> list = new ArrayList<>();
        list.add("Bithumb"); //!empty
        list.add(""); //false
        list.add("kakaoTalk");
        list.add("");
        list.add("Bitcamp");

        //predicate 은 ! 아니면 isempty() 아니면 널체크
        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list, predicate);
        assertThat(newList.size(), is(equalTo(3)));
        assertThat(newList, is(equalTo(Arrays.asList("Bithumb", "kakaoTalk", "Bitcamp"))));

        Predicate<String> filter = s -> s.contains("Talk");
        List<String> talkList = filterList(list, filter);
        assertThat(talkList, is(equalTo(Arrays.asList("kakaoTalk"))));


        Predicate<Integer> Integerfilter = e -> e % 2 == 0;
        List<Integer> intList = Arrays.asList(1, 4, 6, 7, 8);
        List<Integer> solve = filterList(intList, Integerfilter);
        assertThat(solve.size(), is(equalTo(3)));
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T string : list) {
            if (predicate.test(string)) {
                newList.add(string);
            }
        }
        return newList;
    }
}