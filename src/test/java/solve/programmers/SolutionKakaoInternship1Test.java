package solve.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import solve.programmers.kakaoInternship.SolutionKakaoInternship1;

class SolutionKakaoInternship1Test {

    @Test
    void solution_testcase_1() {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        int result = SolutionKakaoInternship1.solution(friends, gifts);
        assertEquals(2, result);
    }

    @Test
    void solution_testcase_2() {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        int result = SolutionKakaoInternship1.solution(friends, gifts);
        assertEquals(4, result);
    }

    @Test
    void solution_testcase_3() {
        String[] friends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        int result = SolutionKakaoInternship1.solution(friends, gifts);
        assertEquals(0, result);
    }
}