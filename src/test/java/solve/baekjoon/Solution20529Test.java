package solve.baekjoon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Solution20529Test {

    @Test
    void solution_testcase_1() {
        int personCount = 3;
        List<String> personList = List.of("ENTJ", "INTP", "ESFJ");

        int result = Solution20529.solution(personCount, personList);
        assertEquals(8, result);
    }

    @Test
    void solution_testcase_2() {
        int personCount = 4;
        List<String> personList = List.of("ESFP", "ESFP", "ESFP", "ESFP");

        int result = Solution20529.solution(personCount, personList);
        assertEquals(0, result);
    }

    @Test
    void solution_testcase_3() {
        int personCount = 5;
        List<String> personList = List.of("INFP", "INFP", "ESTP", "ESTJ", "ISTJ");

        int result = Solution20529.solution(personCount, personList);
        assertEquals(4, result);
    }
}