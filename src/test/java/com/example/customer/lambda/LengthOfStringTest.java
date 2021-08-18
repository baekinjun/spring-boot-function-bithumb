package com.example.customer.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LengthOfStringTest {

    //여기서 테스트 ! 본진에서 고치지 말기!
    @Test
    @DisplayName("길이 자르기 생성")
    void main() {
        LengthOfString len = str -> {
            int l = str.length();
            System.out.println("The length of the given string is " + l);
            return l;
        };

        assertThat(len.main("bithumb"), is(equalTo(7)));
    }
}