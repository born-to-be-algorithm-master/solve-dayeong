package solve.baekjoon;

import java.util.*;

/**
 * 🧞가장 가까운 세 사람의 심리적 거리 - 백준 20529
 * link : https://www.acmicpc.net/problem/20529
 */
public class Solution20529 { // 비둘기 집 원리를 적용해 문제 풀이 시간 단축 필요 -> 16개 이상의 숫자가 들어온 경우 적용 가능, 중복되는 MBTI가 존재할 경우 해당 개수 먼저 처리

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCase = scanner.nextInt();

        for(int i = 0; i < totalTestCase; i++) {
            int personCount = scanner.nextInt();
            scanner.nextLine();

            List<String> personList = List.of(scanner.nextLine().split(" "));

            System.out.println(solution(personCount, personList));
        }
    }

    public static int solution(int personCount, List<String> personList) {

        // MBTI가 3개 이상 중복되는 경우를 예외 처리 해줬더니 시간 초과 문제가 발생하지 않음... 뭐지?
        HashMap<String, Integer> mbtiMap = parseMBTI(personList);
        List<String> mbtiList = new ArrayList<>();

        for (String key : mbtiMap.keySet()) {
            if (mbtiMap.get(key) >= 3) {
                return 0;
            }
        }

        List<Integer> distances = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            for (int j = i + 1; j < personCount; j++) {
                for (int k = j + 1; k < personCount; k++) {
                    distances.add(
                        getDistance(personList.get(i), personList.get(j), personList.get(k)));
                }
            }
        }

        return distances.stream().min(Integer::compareTo).get();
    }

    private static HashMap<String, Integer> parseMBTI(List<String> personList) {
        HashMap<String, Integer> mbtiMap = new HashMap<>();

        for (String mbti : personList) {
            if (mbtiMap.containsKey(mbti)) {
                mbtiMap.put(mbti, mbtiMap.get(mbti) + 1);
            } else {
                mbtiMap.put(mbti, 1);
            }
        }

        return mbtiMap;
    }

    private static int getDistance(String person1, String person2, String person3) {
        return getDistanceBetweenTwo(person1, person2) + getDistanceBetweenTwo(person2, person3) + getDistanceBetweenTwo(person1, person3);
    }

    private static int getDistanceBetweenTwo(String person1, String person2) {
        int distance = 0;

        for(int i = 0; i < person1.length(); i++) {
            if(person1.charAt(i) != person2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}