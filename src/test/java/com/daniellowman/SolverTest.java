package com.daniellowman;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolverTest {
    @Test
    public void theMapShouldBeHydratedWithTheRespectiveBase10Values() {
        assertEquals(1, (int)Solver.characters.get('I'));
        assertEquals(5, (int)Solver.characters.get('V'));
        assertEquals(10, (int)Solver.characters.get('X'));
        assertEquals(50, (int)Solver.characters.get('L'));
        assertEquals(100, (int)Solver.characters.get('C'));
        assertEquals(500, (int)Solver.characters.get('D'));
        assertEquals(1000, (int)Solver.characters.get('M'));
    }

    @Test
    public void theSolveMethodShouldReturnTheCorrectValueForASingleCharacter() {
        // Given
        var solver = new Solver();
        var romanNumeral = "M";

        // When
        var result = solver.solve(romanNumeral);

        // Then
        assertEquals(1000, result);
    }

    @Test
    public void theSolveMethodShouldReturnTheCorrectValueForTwoCharactersOfTheSameValue() {
        // Given
        var solver = new Solver();
        var romanNumeral = "MM";

        // When
        var result = solver.solve(romanNumeral);

        // Then
        assertEquals(2000, result);
    }

    @Test
    public void theSolveMethodShouldReturnTheCorrectValueWhenALargerCharacterAppearsAfterASmallerCharacter() {
        // Given
        var solver = new Solver();
        var romanNumeral = "CM";

        // When
        var result = solver.solve(romanNumeral);

        // Then
        assertEquals(900, result);
    }

    @Test
    public void theSolveMethodShouldReturnTheCorrectValueWhenASmallerCharacterAppearsAfterALargerCharacter() {
        // Given
        var solver = new Solver();
        var romanNumeral = "MC";

        // When
        var result = solver.solve(romanNumeral);

        // Then
        assertEquals(1100, result);
    }

    @Test
    public void theSolveMethodShouldReturnTheCorrectValueFor2024() {
        // Given
        var solver = new Solver();
        var romanNumeral = "MMXXIV";

        // When
        var result = solver.solve(romanNumeral);

        // Then
        assertEquals(2024, result);
    }
}
