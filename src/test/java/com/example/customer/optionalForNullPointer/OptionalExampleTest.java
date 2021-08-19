package com.example.customer.optionalForNullPointer;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OptionalExampleTest {

    @Data
    class Address {
        private final String street;
        private final String city;
        private final String zipcode;
    }

    @Data
    class Member {
        private final Long id;
        private final String name;
        private final Address address;
    }

    @Data
    class Order {
        private final Long id;
        private final Date date;
        private final Member member;
    }

    // 주문을 한 회원이 살고있는 도시를 반환한다.
    public String getCityOfMemberFromOrder(Order order) {
        return Optional.ofNullable(order)
                .map(Order::getMember)
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("Seoul");
    }

    //주어진 시간(분) 내에 생성된 주문을 한 경우에만 해당 회원 정보를 반환 한다.
    //Optional 인경우는 멤버에 주소값이 없을수도 없으니 사용
    public Optional<Member> getMemberifOrderWithin(Order order, int min) {
        return Optional.ofNullable(order)
                .filter(o -> o.getDate().getTime() > System.currentTimeMillis() - min * 1000)
                .map(Order::getMember);
    }

    @Test
    void OptionalMethodTest() {
        Integer a = 10;
        //널이 될수도있는 값
        Optional<Integer> optional = Optional.of(a);
        Integer integerValue = optional.get();
        assertThat(integerValue, is(equalTo(10)));

        Optional<Integer> emptyOptional = Optional.empty();
        //String s = "" ; 이것과 같은값! 널은 아니다 객체가 있는것이기 떄문에
        Integer val = emptyOptional.isPresent() ? emptyOptional.get() : 0;
        assertThat(val, is(equalTo(0)));

        Integer orElse = emptyOptional.orElse(0);
        //Integer val = emptyOptional.isPresent() ? emptyOptional.get() : 0;이것과 같은 값 !
        assertThat(orElse, is(equalTo(0)));

        Integer orElseGet = emptyOptional.orElseGet(() -> 0);
        assertThat(orElseGet, is(equalTo(0)));
    }

}
