package solve.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 🥬유기농 배추 - 백준 1012
 * 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다.
 * 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.
 * 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다.
 * 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
 * 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 *
 * 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다.
 * 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 * 예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.
 * 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
 *
 * link : https://www.acmicpc.net/problem/1012
 */
public class Solution1012 {

    private static Scanner scanner = new Scanner(System.in);
    private static List<List<Integer>> map;
    private static List<List<Integer>> visited;

    public Solution1012() {
        map = new ArrayList<>();
        visited = new ArrayList<>();
    }

    public static void main(String[] args) {
        // 테스트 케이스 개수 입력
        int totalTestcase = scanner.nextInt();

        for (int i = 0; i < totalTestcase; i++) {
            map = new ArrayList<>();
            visited = new ArrayList<>();

            List<Integer[]> cabbageList = new ArrayList<>();

            // 배추밭의 가로, 세로, 배추 개수 입력
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            int cabbageCount = scanner.nextInt();

            for(int j = 0; j < cabbageCount; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                cabbageList.add(new Integer[]{x, y});
            }

            int result = solution(row, column, cabbageCount, cabbageList);
            System.out.println(result);
        }
    }

    public static int solution(int row, int column, int cabbageCount, List<Integer[]> cabbageList) {
        int result = 0;

        // map init
        for (int i = 0; i < row; i++) {
            List<Integer> mapRowList = new ArrayList<>();
            List<Integer> visitedRowList = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                mapRowList.add(0);
                visitedRowList.add(0);
            }
            map.add(mapRowList);
            visited.add(visitedRowList);
        }

        // 배추 위치 입력
        for (int i = 0; i < cabbageCount; i++) {
            int x = cabbageList.get(i)[0];
            int y = cabbageList.get(i)[1];
            map.get(x).set(y, 1);
        }

//        System.out.println("map = " + map);

        // 배추 흰 지렁이 수 계산
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map.get(i).get(j) == 1 && visited.get(i).get(j) == 0) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(int x, int y) {

        // map 범위 체크 -> 벗어나는 경우 return
        if (x < 0 || x >= map.size() || y < 0 || y >= map.get(0).size()) {
            return;
        }

        // 배추가 심어져 있고, 방문하지 않은 경우
        if (map.get(x).get(y) == 1 && visited.get(x).get(y) == 0) {
            visited.get(x).set(y, 1);
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }

}
