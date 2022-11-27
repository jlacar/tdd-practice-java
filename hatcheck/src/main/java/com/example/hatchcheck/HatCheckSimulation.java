package com.example.hatchcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HatCheckSimulation {
    private final Owner[] customers;
    private final List<Integer> checkNumbers;

    public HatCheckSimulation(int howManyCustomers) {
        checkNumbers = new ArrayList<>();
        customers = initializeSimulation(howManyCustomers);
    }

    private Owner[] initializeSimulation(int count) {
        Owner[] customers = new Owner[count];
        for (int i = 0; i < count; i++) {
            checkNumbers.add(i+1);
            customers[i] = new Owner(i+1);
        }
        return customers;
    }

    public void run(int trials) {
        for (int i = 0; i < trials; i++) {
            Collections.shuffle(checkNumbers);
            for (int j = 0; j < checkNumbers.size(); j++) {
                customers[j].checkout(checkNumbers.get(j));
            }
        }
        reportResults(trials);
    }

    private void reportResults(int trials) {
        System.out.printf("In %d simulations with %d customers, the Hat Check Lady gave...%n", trials, customers.length);
        for (Owner owner : customers) {
            System.out.printf("customer #%d the wrong hat %d times (%.2f%%)%n",
                    owner.checkNumber(), owner.timesGivenWrongHat(),
                    100.0 * owner.timesGivenWrongHat() / trials);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int trials = 10000;
        HatCheckSimulation simulation = new HatCheckSimulation(n);
        simulation.run(trials);
    }
}

class Owner {
    private final int myHatCheckNumber;
    private int timesCheckedOut;
    private int timesGivenWrongHat;

    public Owner(int myHatCheckNumber) {
        this.myHatCheckNumber = myHatCheckNumber;
    }

    public int checkNumber() {
        return myHatCheckNumber;
    }

    public void checkout(int checkNumberOfHatThatIGotBack) {
        timesCheckedOut++;
        if (checkNumberOfHatThatIGotBack != myHatCheckNumber) {
            timesGivenWrongHat++;
        }
    }

    public int timesCheckedOut() {
        return timesCheckedOut;
    }

    public int timesGivenWrongHat() {
        return timesGivenWrongHat;
    }
}