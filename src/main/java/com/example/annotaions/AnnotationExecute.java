package com.example.annotaions;

public class AnnotationExecute {
    public int execute() throws NoSuchFieldException {
        var annotation = Main
                .class
                .getDeclaredField("number")
                .getDeclaredAnnotation(CustomAnnotation.class);

        int firstArgument = annotation.firstArgument();
        int secondArgument = annotation.secondArgument();

        String operation = annotation.operation();
        if ("divide".equals(operation)) {
            if (secondArgument == 0) throw new ArithmeticException("Zero division");
            return firstArgument / secondArgument;
        }
        
        return switch (operation) {
            case "add" -> firstArgument + secondArgument;
            case "subtract" -> firstArgument - secondArgument;
            case "multiply" -> firstArgument * secondArgument;
            default -> throw new IllegalArgumentException("Wrong operation format");
        };
    }
}
