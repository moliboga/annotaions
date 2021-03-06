package com.example.annotaions;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    @CustomAnnotation(operation = "add", firstArgument = 9, secondArgument = 0)
    private static final int number = 1;

    @AddAll
    private static final int firstField = 12;

    @AddAll
    private static final int secondField = 13;

    @AddAll
    private static final int thirdField = 5;


    public static void main(String[] args) throws NoSuchFieldException {
        AnnotationExecute annotationExecute = new AnnotationExecute();
        System.out.println(annotationExecute.execute());
        System.out.println("-------------------------");
        
        getSum();
    }

    private static void getSum() {
        int sum = Arrays.stream(Main.class.getDeclaredFields())
                .filter(field -> field.getAnnotation(AddAll.class) != null)
                .mapToInt(field -> {
                    try {
                        return (int) field.get(null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();
        System.out.println(sum);
    }
}
