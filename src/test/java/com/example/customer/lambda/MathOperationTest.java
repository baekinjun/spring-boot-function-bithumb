package com.example.customer.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MathOperationTest {

    @Test
    @DisplayName("계산기")
    void main() {
        MathOperation plus = (a, b) -> a + b;
        MathOperation times = (a, b) -> a * b;

        assertThat(plus.main(1, 2), is(equalTo(3)));
        assertThat(times.main(1, 2), is(equalTo(2)));
    }

}