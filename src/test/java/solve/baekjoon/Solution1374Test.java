package solve.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Solution1374Test {

    @Test
    void solution_testcase_1() {
        // given
        List<List<Integer>> schedules = new ArrayList<>();
        schedules.add(List.of(6, 15, 21));
        schedules.add(List.of(7, 20, 25));
        schedules.add(List.of(1, 3, 8));
        schedules.add(List.of(3, 2, 14));
        schedules.add(List.of(8, 6, 27));
        schedules.add(List.of(2, 7, 13));
        schedules.add(List.of(4, 12, 18));
        schedules.add(List.of(5, 6, 20));

        // when
        int result = Solution1374.solution(schedules);
        int expected = 5;

        // then
        assertEquals(expected, result);
    }
}