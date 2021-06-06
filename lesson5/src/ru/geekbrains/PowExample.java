package ru.geekbrains;

public class PowExample {

    public static void main(String[] args) {
        PowExample powExample = new PowExample();
        System.out.println(powExample.pow(2, -4)); // 1/16
        System.out.println(powExample.pow(5, 3));
        System.out.println(powExample.pow(8, 0));
    }

    public double pow(double num, int degree) {
        if (degree < 0) {
            return 1 / pow(num, Math.abs(degree));
        } else if (degree == 0) {
            return 1;
        } else {
            return num * pow(num, degree - 1);
        }
    }
}
