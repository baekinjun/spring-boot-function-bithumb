package com.example.customer.lambda;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class MyConsumerTest {

    @Test
    void main() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        //메소드 참조 기능
        Consumer<Integer> consumer = System.out::println;

        //consumer로 프린트 먼저찍은거
        consumer.accept(77);

        //밑에 만든 프린트 함수로 찍은것 리스트를 보내고 컨슈머로 보낸다.
        printElements(list, consumer);
    }

    //list 값을주는대 consumer 로 보내라
    //consumer 는 매개값만 있고 리턴값은 없다.
    private static <T> void printElements(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}