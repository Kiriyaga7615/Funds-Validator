package app;

import java.lang.module.FindException;
import java.util.Scanner;

public class Main {

    static double balance = 1000.00;

    public static void main(String[] args) {
        double amount = getAmount();
        double bbalance = validateAmount(balance, amount);
        balance = balance != bbalance ? balance : getBalance(balance, amount);
    }

    private static double getBalance() {
        return balance;
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static double validateAmount(double balance, double withdrawal) throws FundsException{
        if (withdrawal <= 0 || withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException e) {
                System.out.println("Insufficient funds!");
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
        return balance;
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
