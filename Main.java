package com.proff;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Supply a valid principal between 1k and 1M ");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 10)
                break;
            System.out.println("Enter annual interest rate between 1 and 10%");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if(years >= 1 && years <= 30)
                break;
            System.out.println("Supply years between 1 and 30");
        }

        double mortgage = getMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your mortgage is: " + mortgageFormatted);
    }

    /*
     * mortgage formulae
     *  m = p (r(1+r)^n) /(1+r)^n - 1;
     *  p = principal, n = payment times, r = monthly rate;
     * */
    private static double getMortgage(int principal, float annualInterest, byte years) {
        final byte PERCENT = 100;
        final byte MONTHS = 12;

        int numberOfPayments = years * 12;

        float monthlyRate = annualInterest/PERCENT/MONTHS;

        double monthlyRatePower = Math.pow((1+ monthlyRate), numberOfPayments);

        double numerator = monthlyRate * monthlyRatePower;

        double result = numerator / (monthlyRatePower - 1);

        return principal * result;
    }
}
