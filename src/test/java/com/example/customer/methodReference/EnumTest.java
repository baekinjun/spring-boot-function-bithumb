package com.example.customer.methodReference;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleBinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class EnumTest {

    //필요한것의 생성자를 만든다 없으면 이거치고 classpath 등록!
    //final 을 가진 생성자를 만든다 lombok 이 지원한다.
    @RequiredArgsConstructor
    enum Operation {
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        TIMES("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        private final String symbol;
        private final DoubleBinaryOperator op;

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }

    //apply 매개값 들어오고 리턴값나오기!
    @DisplayName("Enum Test")
    @Test
    void enumTest() {
        assertThat(Operation.PLUS.apply(5, 7), is(equalTo(12.0)));
        assertThat(Operation.MINUS.apply(7, 5), is(equalTo(2.0)));
        assertThat(Operation.TIMES.apply(7, 5), is(equalTo(35.0)));
        assertThat(Operation.DIVIDE.apply(6, 2), is(equalTo(3.0)));
    }


}
