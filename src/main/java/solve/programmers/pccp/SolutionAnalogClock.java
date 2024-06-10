package solve.programmers.pccp;

/**
 * 🕰️ 시계 - PCCP link :
 * https://school.programmers.co.kr/learn/courses/30/lessons/250135?language=java
 */
public class SolutionAnalogClock {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;

        answer = getCountFromMidnight(h2, m2, s2) - getCountFromMidnight(h1, m1, s1);
        if((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) answer++;

        return answer;
    }

    /**
     * 0시 0분 0초부터 h시 m분 s초까지 겹치는 횟수 반환
     *
     * @param h 시
     * @param m 분
     * @param s 초
     * @return 겹치는 횟수
     */
    private int getCountFromMidnight(int h, int m, int s) {
        // 0시 0분 0초 ~ h시 m분 s초까지 겹치는 횟
        int count = -1; // 0시 0분 0초는 분당 한 번 겹치기 때문에 -1로 시작
        double hAngle = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360;
        double mAngle = (m * 6 + s * 0.1) % 360;
        double sAngle = s * 6;

        if (sAngle >= mAngle) { // 초침이 분침을 넘어간 경우
            count++;
        }
        if (sAngle >= hAngle) { // 초침이 시침을 넘어간 경우
            count++;
        }

        count += (h * 60 + m) * 2; // 분당 2번씩 만나는 것 계산
        count -= h; // 59분 -> 0분일 때 초침과 분침이 만나지 않음

        if (h >= 12) { // 11시 59분 59초 -> 12시인 경우 분, 초침이 만나지 않고 12시에 1번만 만나는 것으로 처리
            count -= 2;
        }

        return count;
    }

}
