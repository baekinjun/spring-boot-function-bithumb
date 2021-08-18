package com.example.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MySupplierTest {

    @Test
    void main() {
        Supplier<String> stringSupplier = () -> new String("No Pain , No Gain");
        //supplier 는 getter 밖에 없다. 확인!
        assertThat(stringSupplier.get(), is(equalTo("No Pain , No Gain")));

    }
}