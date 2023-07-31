package com.example.refactortests;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.example.refactortests.Example.removeLocalMaxima;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ExampleTest {

    private int[] original;
    private int[] expected;
    private int[] actual;

    @Nested
    class removeLocalMaxima {
        @Test
        void removeLocalMaximaTest() {
            {
                original = new int[]{-3, 2, 4, 13, 5, 12, 8};
                expected = new int[]{-3, 2, 4, 5, 8};
                actual = removeLocalMaxima(original);

                assertArrayEquals(new int[]{-3, 2, 4, 13, 5, 12, 8}, original);
                assertArrayEquals(expected, actual);
            }

            {
                original = new int[]{18, 1, 3, 6, 7, -5};
                expected = new int[]{1, 3, 6, -5};
                actual = removeLocalMaxima(original);

                assertArrayEquals(new int[]{18, 1, 3, 6, 7, -5}, original);
                assertArrayEquals(expected, actual);
            }

            {
                original = new int[]{-18, 21, 3, 6, 7, 65};
                expected = new int[]{-18, 3, 6, 7};
                actual = removeLocalMaxima(original);

                assertArrayEquals(new int[]{-18, 21, 3, 6, 7, 65}, original);
                assertArrayEquals(expected, actual);
            }

            {
                original = new int[1000];
                Arrays.fill(original, 15);
                original[0] = 20;
                original[999] = 25;
                original[168] = 30;
                actual = removeLocalMaxima(original);

                assertEquals(997, actual.length);
                assertEquals(15, actual[0]);
                assertEquals(15, actual[996]);
            }

            {
                original = new int[1000];
                Arrays.fill(original, 15);
                original[0] = -20;
                original[999] = 25;
                original[168] = 18;
                original[421] = 0;
                actual = removeLocalMaxima(original);

                assertEquals(998, actual.length);
                assertEquals(-20, actual[0]);
                assertEquals(15, actual[997]);
                assertEquals(0, actual[420]);
            }

            {
                original = new int[]{100, 0};
                expected = new int[]{0};
                actual = removeLocalMaxima(original);

                assertArrayEquals(new int[]{100, 0}, original);
                assertArrayEquals(expected, actual);
            }

            {
                original = new int[]{10, 900};
                expected = new int[]{10};
                actual = removeLocalMaxima(original);

                assertArrayEquals(new int[]{10, 900}, original);
                assertArrayEquals(expected, actual);
            }

            {
                original = new int[1000];
                Arrays.fill(original, 10);
                for (int i = 0; i < original.length; i += 2) {
                    original[i] = 20;
                }
                actual = removeLocalMaxima(original);

                assertEquals(500, actual.length);
                assertEquals(10, actual[0]);
            }

            {
                original = new int[15000];
                Arrays.fill(original, 10);
                actual = removeLocalMaxima(original);

                assertArrayEquals(original, actual);
            }

            {
                original = new int[500];
                Arrays.fill(original, 0, 100, 150);
                Arrays.fill(original, 100, 200, 50);
                Arrays.fill(original, 200, 300, 15);
                Arrays.fill(original, 300, 400, 55);
                Arrays.fill(original, 400, 500, 500);
                actual = removeLocalMaxima(original);

                assertArrayEquals(original, actual);
            }

        }

        @Test
        void does_not_change_the_original_array() {
            int[] original = new int[]{-3, 2, 4, 3, 5, 12, 8};
            int[] unchanged = new int[]{-3, 2, 4, 3, 5, 12, 8};

            removeLocalMaxima(original);

            assertArrayEquals(unchanged, original);
        }
    }
}