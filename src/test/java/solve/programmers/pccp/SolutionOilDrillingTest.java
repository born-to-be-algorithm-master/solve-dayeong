package solve.programmers.pccp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionOilDrillingTest {

    @Test
    void solution_testcase_1() {
        // given
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0},
                        {1, 1, 0, 0, 0, 1, 1, 0},
                        {1, 1, 1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0, 1, 1}};

        // when
        int result = new SolutionOilDrilling().solution(land);

        // then
        assertEquals(9, result);
    }

    @Test
    void solution_testcase_2() {
        // given
        int[][] land = {{1, 0, 1, 0, 1, 1},
                        {1, 0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 0, 0},
                        {1, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1}};

        // when
        int result = new SolutionOilDrilling().solution(land);

        // then
        assertEquals(16, result);
    }
}