package com.example.annotaions;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    @CustomAnnotation(operation = "add", firstArgument = 9, secondArgument = 0)
    private final int number = 1;

    public static void main(String[] args) throws NoSuchFieldException {
        AnnotationExecute annotationExecute = new AnnotationExecute();
        System.out.println(annotationExecute.execute());
    }

}
