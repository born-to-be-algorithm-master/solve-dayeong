package solve.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Solution1012Test {

    @Test
    void solution_testcase_1() {
        // given
        Solution1012 solution1012 = new Solution1012();
        int row = 10;
        int column = 8;
        int cabbageCount = 17;
        List<Integer[]> cabbageList = new ArrayList<>();
        cabbageList.add(new Integer[]{0, 0});
        cabbageList.add(new Integer[]{1, 0});
        cabbageList.add(new Integer[]{1, 1});
        cabbageList.add(new Integer[]{4, 2});
        cabbageList.add(new Integer[]{4, 3});
        cabbageList.add(new Integer[]{4, 5});
        cabbageList.add(new Integer[]{2, 4});
        cabbageList.add(new Integer[]{3, 4});
        cabbageList.add(new Integer[]{7, 4});
        cabbageList.add(new Integer[]{8, 4});
        cabbageList.add(new Integer[]{9, 4});
        cabbageList.add(new Integer[]{7, 5});
        cabbageList.add(new Integer[]{8, 5});
        cabbageList.add(new Integer[]{9, 5});
        cabbageList.add(new Integer[]{7, 6});
        cabbageList.add(new Integer[]{8, 6});
        cabbageList.add(new Integer[]{9, 6});

        // when
        int result = solution1012.solution(row, column, cabbageCount, cabbageList);

        // then
        assertEquals(5, result);
    }

    @Test
    void solution_testcase_2() {
        // given
        Solution1012 solution1012 = new Solution1012();
        int row = 10;
        int column = 10;
        int cabbageCount = 1;
        List<Integer[]> cabbageList = new ArrayList<>();
        cabbageList.add(new Integer[]{5, 5});

        // when
        int result = solution1012.solution(row, column, cabbageCount, cabbageList);

        // then
        assertEquals(1, result);
    }
}