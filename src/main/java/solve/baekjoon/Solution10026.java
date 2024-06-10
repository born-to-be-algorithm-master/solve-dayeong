package solve.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 🎨 적록색약 - 백준 10026
 * link : https://www.acmicpc.net/problem/10026
 */
public class Solution10026 {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = scanner.nextLine().toCharArray();
        }

        // calculate
        int[] result = solution(map);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(char[][] map) {
        return new int[] {getNormalCount(map), getAbnormalCount(map)};
    }

    /**
     * 정상인이 보는 구역의 수를 반환
     * @return 정상인이 보는 구역의 수
     */
    private static int getNormalCount(char[][] map) {

        int[][] normalClusterMap = new int[map.length][map.length];

        // init
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                normalClusterMap[i][j] = -1;
            }
        }

        int normalClusterCount = getClusterCount(map, normalClusterMap);
        return normalClusterCount;
    }

    /**
     * 적록색약이 보는 구역의 수를 반환
     * @return 적록색약이 보는 구역의 수
     */
    private static int getAbnormalCount(char[][] map) {

        char[][] preprocessedMap = new char[map.length][map.length];
        int[][] abnormalClusterMap = new int[map.length][map.length];

        // init
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                preprocessedMap[i][j] = map[i][j] == 'G' ? 'R' : map[i][j];
                abnormalClusterMap[i][j] = -1;
            }
        }
        int abnormalClusterCount = getClusterCount(preprocessedMap, abnormalClusterMap);
        return abnormalClusterCount;
    }

    /**
     * 구역의 수를 구하는 메소드
     * @param originMap 구역의 맵
     * @param clusterMap 구역명을 입력할 맵
     *
     * @return 구역의 수
     */
    private static int getClusterCount(char[][] originMap, int[][] clusterMap) {
        int clusterCount = 0;

        for (int i = 0; i < originMap.length; i++) {
            for (int j = 0; j < originMap[0].length; j++) {
                if (clusterMap[i][j] == -1) {
                    clusterMap = bfs(originMap, clusterMap, clusterCount, i, j);
                    clusterCount++;
                }
            }
        }

        return clusterCount;
    }

    /**
     * BFS로 구역을 구하는 메소드
     * @param originMap 구역의 맵
     * @param clusterMap 구역명을 입력할 맵
     * @param clusterCount 구역의 수
     * @param x 구역의 x 좌표
     * @param y 구역의 y 좌표
     *
     * @return 구역명이 입력된 맵
     */
    private static int[][] bfs(char[][] originMap, int[][] clusterMap, int clusterCount, int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        clusterMap[x][y] = clusterCount;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            List<int[]> closePositions = getClosePosition(originMap, current[0], current[1]);
            for (int[] position : closePositions) {
                if (clusterMap[position[0]][position[1]] != -1) continue;
                clusterMap[position[0]][position[1]] = clusterCount;
                queue.add(position);
            }
        }

        return clusterMap;
    }

    /**
     * 현재 위치에서 인접한 같은 색의 위치를 반환
     * @param map 구역의 맵
     * @param x x 좌표
     * @param y y 좌표
     *
     * @return 인접한 같은 색의 위치 리스트
     */
    private static List<int[]> getClosePosition(char[][] map, int x, int y) {
        char currentColor = map[x][y];
        List<int[]> closePositions = new ArrayList<>();

        if (x - 1 >= 0 && map[x - 1][y] == currentColor) {
            closePositions.add(new int[]{x - 1, y});
        }
        if (x + 1 < map.length && map[x + 1][y] == currentColor) {
            closePositions.add(new int[]{x + 1, y});
        }
        if (y - 1 >= 0 && map[x][y - 1] == currentColor) {
            closePositions.add(new int[]{x, y - 1});
        }
        if (y + 1 < map[0].length && map[x][y + 1] == currentColor) {
            closePositions.add(new int[]{x, y + 1});
        }
        return closePositions;
    }
}
