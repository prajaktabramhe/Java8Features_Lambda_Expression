package com.bridgelabz;

@FunctionalInterface
interface IMathFunction
{
    int calculate(int a, int b);
    static void printResult(int a, int b, String function, IMathFunction fobj)
    {
        System.out.println("Result of " + function + " is" + fobj.calculate(a, b));
    }
}

public class MathOperationApp
{
    public static void main(String[] args)
    {

        //This expression implements 'IMathFunction' interface
        IMathFunction add = Integer::sum;
        //Lambda expression for multiplication & division for two parameters.
        //This expression implements 'IMathFunction'

        IMathFunction subtraction = (x,y) -> x - y;
        IMathFunction multiply = (x,y) -> x * y;
        IMathFunction divide = (int x, int y) -> x / y;

        //Add & Multiply two numbers using Lambda expression
        System.out.println("Addition is " + add.calculate(6, 3));
        System.out.println("Subtraction is " + subtraction.calculate(6, 3));
        System.out.println(("Multiplication is " + multiply.calculate(6, 3)));
        System.out.println(("Division is " + divide.calculate(6, 3)));

        IMathFunction.printResult(6, 3, "Addition", add);
        IMathFunction.printResult(6, 3, "Subtraction", subtraction);
        IMathFunction.printResult(6, 3, "Multiplication", multiply);
        IMathFunction.printResult(6, 3, "Division", divide);
    }
}
