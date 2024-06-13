package solve.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * 🏛️강의실 - 백준 1374
 * link : https://www.acmicpc.net/problem/1374
 */
public class Solution1374 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<List<Integer>> schedules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int lectureNum = scanner.nextInt();
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            schedules.add(List.of(lectureNum, start, end));
        }

        int result = solution(schedules);

        System.out.println(result);
    }

    /**
     * solution method
     * @param schedules 강의 일정 리스트
     * @return 강의실 개수
     */
    public static int solution(List<List<Integer>> schedules) {
        // schedules를 시작 시간 순으로 정렬
        schedules.sort((o1, o2) -> {
            if (Objects.equals(o1.get(1), o2.get(1))) {
                return o1.get(2) - o2.get(2);
            }
            return o1.get(1) - o2.get(1);
        });

        // 강의실 개수를 구하기
        List<List<List<Integer>>> rooms = getRooms(schedules);

        return rooms.size();
    }

    /**
     * 강의실 리스트를 구하는 메소드
     * @param schedules 강의 일정 리스트
     * @return 강의실 리스트
     */
    private static List<List<List<Integer>>> getRooms(List<List<Integer>> schedules) {

        List<List<List<Integer>>> rooms = new ArrayList<>();

        for (List<Integer> schedule : schedules) {
            int availableRoomIndex = getAvailableRoomIndex(rooms, schedule);

            if (availableRoomIndex == -1) {
                List<List<Integer>> newRoom = new ArrayList<>();
                newRoom.add(schedule);
                rooms.add(newRoom);
            } else {
                rooms.get(availableRoomIndex).add(schedule);
            }
        }

        return rooms;
    }

    /**
     * 강의실 리스트에 있는 강의실 중에서 강의를 할 수 있는 강의실의 인덱스를 반환하는 메소드
     * @param rooms 강의실 리스트
     * @param schedule 강의 일정
     * @return 강의를 할 수 있는 강의실의 인덱스(없으면 -1)
     */
    private static int getAvailableRoomIndex(List<List<List<Integer>>> rooms, List<Integer> schedule) {
        List<Integer> avlilableRoomList = new ArrayList<>();
        int availableRoomIndex = -1;

        for (int i = 0; i < rooms.size(); i++) {
            if (isAllocatable(rooms.get(i), schedule)) {
                avlilableRoomList.add(i);
            }
        }

        if (avlilableRoomList.isEmpty()) {
            return -1;
        }

        int minEnd = Integer.MAX_VALUE;
        for (int i : avlilableRoomList) {
            int end = rooms.get(i).get(rooms.get(i).size() - 1).get(2);
            if (end < minEnd) {
                minEnd = end;
                availableRoomIndex = i;
            }
        }

        return availableRoomIndex;
    }

    private static boolean isAllocatable(List<List<Integer>> room, List<Integer> schedule) {

        int lastEnd = room.get(room.size() - 1).get(2);
        int start = schedule.get(1);

        return lastEnd <= start;
    }
}
