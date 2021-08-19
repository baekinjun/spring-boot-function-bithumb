package com.example.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

//Unary 단일항 반환
class MyUnaryOpTest {

    @Test
    void test1() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        UnaryOperator<Integer> operator = i -> i * 100;
        List<Integer> newList = mapper(list, operator);
        assertThat(newList.get(0), is(equalTo(1000)));


    }

    private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();
        for (T i : list) {
            newList.add(operator.apply(i));
        }
        return newList;
    }
}