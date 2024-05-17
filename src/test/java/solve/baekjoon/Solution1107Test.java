package solve.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Solution1107Test {

    @Test
    void solution_testcase_1() {
        // given
        int targetChannel = 5457;
        int brokenButtonCount = 3;
        List<Integer> brokenButtons = List.of(6, 7, 8);

        // when
        int result = Solution1107.solution(targetChannel, brokenButtons);

        // then
        assertEquals(6, result);
    }

    @Test
    void solution_testcase_2() {
        // given
        int targetChannel = 100;
        int brokenButtonCount = 5;
        List<Integer> brokenButtons = List.of(0, 1, 2, 3, 4);

        // when
        int result = Solution1107.solution(targetChannel, brokenButtons);

        // then
        assertEquals(0, result);
    }

    @Test
    void solution_testcase_3() {
        // given
        int targetChannel = 14124;
        int brokenButtonCount = 0;
        List<Integer> brokenButtons = new ArrayList<>();

        // when
        int result = Solution1107.solution(targetChannel, brokenButtons);

        // then
        assertEquals(5, result);
    }

    @Test
    void solution_testcase_4() {
        // given
        int targetChannel = 0;
        int brokenButtonCount = 10;
        List<Integer> brokenButtons = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // when
        int result = Solution1107.solution(targetChannel, brokenButtons);

        // then
        assertEquals(100, result);
    }
}