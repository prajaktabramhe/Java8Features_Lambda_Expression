package com.bridgelabz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {
        // creating simple collection
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) myNumberList.add(1);


        //Method1: Traversing using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
        }
        //Method 2: Traversing with Consumer integer implementation
        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println(("Mth2: Consumer impl Value::" + t));
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        //Method3: Traversing with Anonymous Consumer interface implementations
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class Value::" + t);
            }
        });

        //Method 4:Explicit Lambda Function
        Consumer<Integer> myListAction = n -> {
            System.out.println(("Mth4: forEach Lambda impl Value::" + n));
        };
        myNumberList.forEach(myListAction);

        //Method 5: Implicit Lambda Function
        myNumberList.forEach(n -> {
            System.out.println(("Mth5: forEach Lambda impl Value::" + n));
        });

        //Method 6: Implicit Lambda function to print double value
        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n -> {
            System.out.println(("Mth6: forEach Lambda impl Value::" + toDoubleFunction.apply(n)));
        });

        //Method 7: Implicit Lambda function to print double value
        Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 == 0;
        myNumberList.forEach(n -> {
            System.out.println(("Mth7: forEach Lambda impl Value::" + isEvenFunction.test(n)));
        });

        //Method 8: Processing the stream
        myNumberList.stream().forEach(n ->{
            System.out.println("Mth8: Stream forEch Value:" + n);
        });
        //Method 9: Processing the stream, Apply Operations on the Stream and then
        // store the Result
        List<Double> streamList = myNumberList.stream()
                                  .map(toDoubleFunction)
                                  .collect(Collectors.toList());
        System.out.println("Mth9: Printing Double List:" + streamList);

    }
}
