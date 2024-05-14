package solve.programmers.kakaoInternship;

import java.util.*;

/**
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */

public class SolutionKakaoInternship1 {
    public static Map<String, Map<String, Integer>> currGiftCountMap = new HashMap<>(); // 현재까지 주고 받은 선물 개수
    public static Map<String, Integer> nextGiftCountMap = new HashMap<>(); // 다음 달 선물 개수
    public static Map<String, Integer> giftNumberMap = new HashMap<>(); // 선물 지수

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        // init
        for (int i = 0; i < friends.length; i++) {
            currGiftCountMap.put(friends[i], new HashMap<>());
            for (int j = 0; j < friends.length; j++) {
                if(i != j){
                    currGiftCountMap.get(friends[i]).put(friends[j], 0);
                }
            }
            nextGiftCountMap.put(friends[i], 0);
            giftNumberMap.put(friends[i], 0);
        }

        // 선물 주고 받은 통계 계산
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String give = gift[0];
            String get = gift[1];

            // 현재까지 주고 받은 선물 개수 계산
            if (currGiftCountMap.get(give).containsKey(get)) {
                currGiftCountMap.get(give).put(get, currGiftCountMap.get(give).get(get) + 1);
            } else {
                currGiftCountMap.get(give).put(get, 1);
            }

            // 선물 지수 계산
            giftNumberMap.put(give, giftNumberMap.get(give) + 1);
            giftNumberMap.put(get, giftNumberMap.get(get) - 1);
        }

        // 다음 달 선물 개수 계산
        for (int i = 0; i < friends.length; i++) {
            String friend = friends[i];
            for (String otherFriend : currGiftCountMap.get(friend).keySet()) {
                int fToOther = currGiftCountMap.get(friend).get(otherFriend); // friend -> other friend에게 준 선물 개수
                int OtherTof = currGiftCountMap.get(otherFriend).get(friend); // other friend -> friend에게 준 선물 개수

                if(fToOther - OtherTof > 0) { // 받은 것보다 준 게 더 많은 경우
                    nextGiftCountMap.put(friend, nextGiftCountMap.get(friend) + 1);
                }
                else if(fToOther == OtherTof) { // 받은 것과 준 것이 같은 경우
                    if(giftNumberMap.get(friend) > giftNumberMap.get(otherFriend)) {
                        nextGiftCountMap.put(friend, nextGiftCountMap.get(friend) + 1);
                    }
                }
            }
        }

        // 선물을 가장 많이 받는 친구의 선물 개수 찾기
        for (int i = 0; i < friends.length; i++) {
            answer = Math.max(answer, nextGiftCountMap.get(friends[i]));
        }

        return answer;
    }
}
