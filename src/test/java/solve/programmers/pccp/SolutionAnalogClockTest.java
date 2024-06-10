package solve.programmers.pccp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionAnalogClockTest {

    @Test
    void solution_testcase_1() {
        // given
        int h1 = 0;
        int m1 = 5;
        int s1 = 30;
        int h2 = 0;
        int m2 = 7;
        int s2 = 0;
        int expected = 2;

        // when
        SolutionAnalogClock solutionAnalogClock = new SolutionAnalogClock();
        int actual = solutionAnalogClock.solution(h1, m1, s1, h2, m2, s2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void solution_testcase_2() {
        // given
        int h1 = 12;
        int m1 = 0;
        int s1 = 0;
        int h2 = 12;
        int m2 = 0;
        int s2 = 30;
        int expected = 1;

        // when
        SolutionAnalogClock solutionAnalogClock = new SolutionAnalogClock();
        int actual = solutionAnalogClock.solution(h1, m1, s1, h2, m2, s2);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void solution_testcase_3() {
        // given
        int h1 = 0;
        int m1 = 0;
        int s1 = 0;
        int h2 = 23;
        int m2 = 59;
        int s2 = 59;
        int expected = 2852;

        // when
        SolutionAnalogClock solutionAnalogClock = new SolutionAnalogClock();
        int actual = solutionAnalogClock.solution(h1, m1, s1, h2, m2, s2);

        // then
        assertEquals(expected, actual);
    }
}