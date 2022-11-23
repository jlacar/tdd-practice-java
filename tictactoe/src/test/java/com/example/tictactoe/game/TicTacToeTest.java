package com.example.tictactoe.game;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TicTacToeTest {

    @Test
    void it_is_ready_to_run_JUnit5_tests() {
        assertEquals(1, 1);
    }
}