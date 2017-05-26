package ua.com.shcherbakov.sergii.factorial;

/**
 * Created by Sergii Shcherbakov on 21.05.2017.
 * The class starts decision for the third test.
 * The class uses class factorial to find count digits from factorial of 100.
 */
public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int answer = factorial.getSumDigits(100);
        System.out.println("Sum digits of factorial 100 is \"" + answer + "\"");
    }
}