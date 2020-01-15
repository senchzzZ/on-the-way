package com.exp.zsq.lambda;

import com.exp.zsq.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/13 下午2:27
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Car> car = Optional.empty();
        Optional<Car> car1 = Optional.of(new Car("涉水险"));
        System.out.println(car1.get());

        /*Optional<Car> car2 = Optional.ofNullable(new Car(null));
        Optional<String> insurance = car2.map(Car::getInsurance);
        System.out.println(insurance.get());*/

        Optional<Person> person = Optional.ofNullable(new Person(Optional.of(new Car(null))));
        String insurance1 = person.flatMap(Person::getCar)
                                            .map(Car::getInsurance)
                                            .orElse("abc");
        System.out.println(insurance1);
    }

    @Data
    @AllArgsConstructor
    static class Car {
        String insurance;
    }
    @Data
    @AllArgsConstructor
    static class Person {
       Optional<Car> car;
    }
}
