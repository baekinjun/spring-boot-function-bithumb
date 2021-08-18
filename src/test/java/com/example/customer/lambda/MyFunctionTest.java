package com.example.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MyFunctionTest {

    @Test
    void main() {
        List<String> list = Arrays.asList("Bithumb", "Company", "Market");
        //메소드참조 클래스 메소드
        Function<String, Integer> function = String::length;
        List<Integer> newList = map(list, function);

        assertThat(newList.get(1), is(equalTo(7)));

    }

    //앞에가 데이터들어오는것
    //map 은 매핑!
    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T e : list) {
            newList.add(function.apply(e));
        }
        return newList;
    }

}