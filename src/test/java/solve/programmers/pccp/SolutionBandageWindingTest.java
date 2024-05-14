package solve.programmers.pccp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionBandageWindingTest {

    @Test
    void solution_testcase_1() {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        SolutionBandageWinding solutionBandageWinding = new SolutionBandageWinding();
        int result = solutionBandageWinding.solution(bandage, health, attacks);

        assertEquals(5, result);
    }

    @Test
    void solution_testcase_2() {
        int[] bandage = {3, 2, 7};
        int health = 20;
        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};

        SolutionBandageWinding solutionBandageWinding = new SolutionBandageWinding();
        int result = solutionBandageWinding.solution(bandage, health, attacks);

        assertEquals(-1, result);
    }

    @Test
    void solution_testcase_3() {
        int[] bandage = {4, 2, 7};
        int health = 20;
        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};

        SolutionBandageWinding solutionBandageWinding = new SolutionBandageWinding();
        int result = solutionBandageWinding.solution(bandage, health, attacks);

        assertEquals(-1, result);
    }

    @Test
    void solution_testcase_4() {
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};

        SolutionBandageWinding solutionBandageWinding = new SolutionBandageWinding();
        int result = solutionBandageWinding.solution(bandage, health, attacks);

        assertEquals(3, result);
    }
}