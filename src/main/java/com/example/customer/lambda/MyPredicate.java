package com.example.customer.lambda;

@FunctionalInterface
public interface MyPredicate {
    Boolean test(String str);
}
