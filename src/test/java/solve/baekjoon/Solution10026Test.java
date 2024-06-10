package solve.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Solution10026Test {

    @Test
    void solution_testcase_1() {
        char[][] map = {
            {'R', 'R', 'R', 'B', 'B'},
            {'G', 'G', 'B', 'B', 'B'},
            {'B', 'B', 'B', 'R', 'R'},
            {'B', 'B', 'R', 'R', 'R'},
            {'R', 'R', 'R', 'R', 'R'}
        };

        int[] result = Solution10026.solution(map);
        assertArrayEquals(new int[] {4, 3}, result);
    }
}