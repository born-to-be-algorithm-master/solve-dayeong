package solve.programmers.pccp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 🛢️석유 시추 - PCCP
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */
public class SolutionOilDrilling {

    private int[] oilDrillingResultList; // 각 x 좌표별 석유 시추 결과
    private Boolean[][] oilVisitList; // dfs 방문 체크
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

    private int getOilCount(int[][] land, int x, int y) {
        if (x < 0 || y < 0 || y >= land.length || x >= land[0].length) {
            return 0;
        }

        if (land[y][x] == 0 || oilVisitList[y][x]) {
            return 0;
        }

        oilVisitList[y][x] = true;
        oilClusterList.add(new Integer[]{y, x});
        int count = 1;
        count += getOilCount(land, x + 1, y);
        count += getOilCount(land, x - 1, y);
        count += getOilCount(land, x, y + 1);
        count += getOilCount(land, x, y - 1);
        return count;
    }

    private Boolean[][] getInitial2DArray(int width, int height) {
           Boolean[][] list = new Boolean[height][width];
            for (int i = 0; i < height; i++) {
                Arrays.fill(list[i], false);
            }
            return list;
    }
}
