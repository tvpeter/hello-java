package com.proff;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();

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
