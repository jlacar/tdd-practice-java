package com.example.hatchcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HatCheck {
    public static void main(String[] args) {
        int trials = 10000;
        int n = 5;
        Owner[] hatOwners = new Owner[n];
        List<Integer> checkNumbers = consecutiveCheckNumbers(n);
        for (int i = 0; i < n; i++) {
            hatOwners[i] = new Owner(checkNumbers.get(i));
        }
        for (int i = 0; i < trials; i++) {
            Collections.shuffle(checkNumbers);
            for (int j = 0; j < checkNumbers.size(); j++) {
                hatOwners[j].getHatBack(checkNumbers.get(j));
            }
        }
        System.out.printf("In %d simulations with %d customers, the Hat Check Lady gave...%n", trials, n);
        for (Owner owner : hatOwners) {
            System.out.printf("customer #%d the wrong hat %d times (%.2f%%)%n",
                    owner.checkNumber(), owner.timesGivenWrongHat(),
                    100.0 * owner.timesGivenWrongHat() / trials);
        }
    }

    private static List<Integer> consecutiveCheckNumbers(int hatCount) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < hatCount; i++) {
            numbers.add(i + 1);
        }
        return numbers;
    }
}

class Owner {
    private final int checkNumber;
    private int timesCheckedOut;
    private int timesGivenWrongHat;

    public Owner(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public int checkNumber() {
        return checkNumber;
    }

    public void getHatBack(int checkNumber) {
        timesCheckedOut++;
        if (checkNumber != this.checkNumber) {
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