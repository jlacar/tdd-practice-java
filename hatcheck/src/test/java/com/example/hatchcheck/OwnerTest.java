package com.example.hatchcheck;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OwnerTest {

    @Nested
    class An_Owner {
        @Test
        void knows_their_hat_check_number() {
            Owner owner = new Owner(1);
            assertEquals(1, owner.checkNumber());
        }

        @Test
        void knows_how_many_times_they_have_checked_out() {
            Owner owner = new Owner(1);

            owner.checkout(1);
            owner.checkout(2);

            assertEquals(2, owner.timesCheckedOut());
        }

        @Test
        void knows_how_many_times_they_got_the_wrong_hat_back() {
            Owner owner = new Owner(1);

            owner.checkout(2);
            owner.checkout(2);

            assertEquals(2, owner.timesGivenWrongHat());
        }
    }
}