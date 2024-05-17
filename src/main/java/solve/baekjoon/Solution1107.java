package solve.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 📺리모컨 - 백준 1107
 * link : https://www.acmicpc.net/problem/1107
 */
public class Solution1107 {

    public static final Integer INITIAL_CHANNEL = 100;
    public static final Integer MAX_CHANNEL = 999999;
    public static final Integer MIN_CHANNEL = 0;

    /**
     * 리모컨을 이용하여 이동할 채널을 입력받아 가장 적은 버튼을 눌러 이동하는 방법을 찾는 main method
     * @param args 사용하지 않음
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int targetChannel = Integer.parseInt(br.readLine());
        int brokenButtonCount = Integer.parseInt(br.readLine());
        List<Integer> brokenButtons = new ArrayList<>();

        if (brokenButtonCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenButtonCount; i++) {
                brokenButtons.add(Integer.parseInt(st.nextToken()));
            }
        }

        // calculate
        Integer result = solution(targetChannel, brokenButtons);
        System.out.println(result);

        br.close();
    }

    /**
     * 리모컨을 이용하여 이동할 채널을 입력받아 가장 적은 버튼을 눌러 이동하는 방법을 찾는 method
     * @param targetChannel 이동할 채널
     * @param brokenButtons 고장난 버튼들
     *
     * @return 버튼을 누르는 수의 최솟값
     */
    public static Integer solution(Integer targetChannel, List<Integer> brokenButtons) {
        int currChannel = INITIAL_CHANNEL;
        int buttonCount = 0;
        Map<Integer, Integer> channelMap = new HashMap<>(); // key : channel, value : buttonCount

        if (currChannel == targetChannel) { // 현재 시청 중인 채널로 이동하고자 하는 경우
            return buttonCount;
        }

        if (getButtonCountFromChannel(targetChannel, currChannel) < targetChannel.toString().length() || brokenButtons.size() == 10) { // +, - 버튼만으로 이동하는 경우
            return getButtonCountFromChannel(targetChannel, currChannel);
        }

        return Math.min(getChangeChannelButtonCount(targetChannel, brokenButtons), getButtonCountFromChannel(targetChannel, currChannel));
    }

    private static Integer getChangeChannelButtonCount(Integer targetChannel, List<Integer> brokenButtons) {

        int currChannel = INITIAL_CHANNEL;
        Map<Integer, Integer> channelMap = new HashMap<>(); // key : channel, value : buttonCount

        for (int i = MIN_CHANNEL; i < MAX_CHANNEL; i++) {
            currChannel = i;
            String currNum = Integer.toString(currChannel);
            boolean isBroken = false;

            for(int j = 0; j < currNum.length(); j++) {
                if (brokenButtons.contains(Integer.parseInt(String.valueOf(currNum.charAt(j))))){
                    isBroken = true;
                    break;
                }
            }

            if(!isBroken) {
                channelMap.put(Integer.valueOf(currNum), getButtonCount(targetChannel, currChannel));
            }
        }
        return channelMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
    }

    private static Integer getButtonCount(Integer targetChannel, Integer currChannel) {
        int buttonCount = 0;
        buttonCount += Integer.toString(currChannel).length();
        buttonCount += getButtonCountFromChannel(targetChannel, currChannel);
        return buttonCount;
    }

    private static Integer getButtonCountFromChannel(Integer targetChannel, Integer currChannel) {
        return Math.abs(targetChannel - currChannel);
    }
}
