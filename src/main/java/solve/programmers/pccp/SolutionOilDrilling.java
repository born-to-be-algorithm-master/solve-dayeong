package solve.programmers.pccp;

import java.util.*;

/**
 * 🛢️석유 시추 - PCCP
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */
public class SolutionOilDrilling {

    private int[] oilDrillingResultList; // 각 x 좌표별 석유 시추 결과
    private Boolean[][] oilVisitList; // bfs 방문 체크
    private List<Integer> landOilAmount = new ArrayList<>(); // 석유가 모여있는 군집별 석유량
    private int[][] landMap; // 석유가 모여있는 군집을 표시한 맵
    private List<Integer[]> oilClusterList = new ArrayList<>(); // 석유가 모여있는 군집 리스트

    public int solution(int[][] land) {

        // init
        int width = land[0].length;
        int height = land.length;
        landMap = new int[height][width];
        oilDrillingResultList = new int[width];
        Arrays.fill(oilDrillingResultList, 0);
        for (int i = 0; i < height; i++) Arrays.fill(landMap[i], -1);

        for (int x = 0; x < width; x++) { // x
            // init
            List<Integer> currColOilClusters = new ArrayList<>(); // 현재 x 좌표에서 시추 가능한 석유 군집들
            oilVisitList = getInitial2DArray(width, height); // 방문 체크 초기화

            for (int y = 0; y < height; y++) { // y
                if (landMap[y][x] != -1) { // 이미 석유가 있다고 판별된 군집일 경우
                    currColOilClusters.add(landMap[y][x]);
                }
                else { // 군집이 없는 경우
                    int oilAmount = getOilCount(land, x, y);
                    if (oilAmount == 0) continue;
                    landOilAmount.add(oilAmount);
                    for (Integer[] oilLocation : oilClusterList) {
                        landMap[oilLocation[0]][oilLocation[1]] = landOilAmount.size() - 1;
                    }
                    oilClusterList.clear();
                    currColOilClusters.add(landOilAmount.size() - 1);
                }
            }
//            currColOilClusters = currColOilClusters.stream().distinct().collect(Collectors.toList());
             Set<Integer> set = new HashSet<>(currColOilClusters);
             currColOilClusters.clear();
             currColOilClusters.addAll(set);
            for (Integer cluster : currColOilClusters) {
                oilDrillingResultList[x] += landOilAmount.get(cluster);
            }
        }

//        int answer = Arrays.stream(oilDrillingResultList).max().getAsInt();
        int max = 0;
        for (int i = 0; i < oilDrillingResultList.length; i++) {
            if (oilDrillingResultList[i] > max) {
                max = oilDrillingResultList[i];
            }
        }
        return max;
    }

    private int getOilCountRecursive(int[][] land, int x, int y) {

        if (x < 0 || y < 0 || y >= land.length || x >= land[0].length) {
            return 0;
        }

        if (land[y][x] == 0 || oilVisitList[y][x]) {
            return 0;
        }

        oilVisitList[y][x] = true;
        oilClusterList.add(new Integer[]{y, x});

        int count = 1;
        count += getOilCountRecursive(land, x + 1, y);
        count += getOilCountRecursive(land, x - 1, y);
        count += getOilCountRecursive(land, x, y + 1);
        count += getOilCountRecursive(land, x, y - 1);
        return count;
    }

    /**
     * 석유 군집의 석유량을 구하는 함수(BFS, Queue 사용)
     * @param land 석유 군집이 있는 땅
     * @param x 탐색 대상의 x 좌표
     * @param y 탐색 대상의 y 좌표
     * @return 석유 군집의 석유량
     */
    private int getOilCount(int[][] land, int x, int y) {

        int count = 0;

        if (x < 0 || y < 0 || y >= land.length || x >= land[0].length) {
            return count;
        }

        if (land[y][x] == 0 || oilVisitList[y][x]) {
            return count;
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{y, x});
        oilVisitList[y][x] = true;
        oilClusterList.add(new Integer[]{y, x});
        count++;

        while (!queue.isEmpty()) {
            Integer[] nodeIndex = queue.poll();
            List<Integer[]> closeOilPositions = getCloseOilPosition(land, nodeIndex[1], nodeIndex[0]);
            for (Integer[] position : closeOilPositions) {
                if (oilVisitList[position[0]][position[1]]) continue;
                queue.add(position);
                oilClusterList.add(position);
                oilVisitList[position[0]][position[1]] = true;
                count++;
            }
        }

        return count;
    }

    private Boolean[][] getInitial2DArray(int width, int height) {
           Boolean[][] list = new Boolean[height][width];
            for (int i = 0; i < height; i++) {
                Arrays.fill(list[i], false);
            }
            return list;
    }

    private List<Integer[]> getCloseOilPosition(int[][] land, int x, int y) {
        List<Integer[]> oilPositionList = new ArrayList<>();
        if (x - 1 >= 0 && land[y][x - 1] == 1) {
            oilPositionList.add(new Integer[]{y, x - 1});
        }
        if (x + 1 < land[0].length && land[y][x + 1] == 1) {
            oilPositionList.add(new Integer[]{y, x + 1});
        }
        if (y - 1 >= 0 && land[y - 1][x] == 1) {
            oilPositionList.add(new Integer[]{y - 1, x});
        }
        if (y + 1 < land.length && land[y + 1][x] == 1) {
            oilPositionList.add(new Integer[]{y + 1, x});
        }
        return oilPositionList;
    }
}
