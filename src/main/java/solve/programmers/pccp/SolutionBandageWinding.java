package solve.programmers.pccp;

/**
 * 🩹붕대 감기 - PCCP
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/250137?language=java
 */
public class SolutionBandageWinding {

    public int MAX_HEALTH;
    public int MAX_CONTINUOUS_COUNT;
    public int HEAL_PER_SECOND;
    public int ADDITIONAL_HEAL;

    public int continuousCount = 0;
    public int currAttackIndex = 0;
    public int currHealth;

    public int solution(int[] bandage, int health, int[][] attacks) {


        currHealth = health;

        // set static variables
        MAX_HEALTH = health;
        MAX_CONTINUOUS_COUNT = bandage[0];
        HEAL_PER_SECOND = bandage[1];
        ADDITIONAL_HEAL = bandage[2];

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if(attacks[currAttackIndex][0] == i) { // 공격 당하는 경우
                setAttackedHealth(attacks[currAttackIndex][1]);
            } else {
                setHealedHealth();
            }

            if(currHealth <= 0) return -1;
        }

        return currHealth;
    }

    private void setAttackedHealth(int attackAmount) {
        continuousCount = 0;
        currHealth -= attackAmount;
        if (currAttackIndex < MAX_HEALTH - 1) currAttackIndex++;
    }

    private void setHealedHealth() {

        continuousCount++;

        if(isMaxHealth(currHealth)) {
            return;
        }

        currHealth += HEAL_PER_SECOND;

        if(continuousCount == MAX_CONTINUOUS_COUNT) {
            currHealth += ADDITIONAL_HEAL;
            continuousCount = 0;
        }

        checkHealthIsOverMax();
    }

    private void checkHealthIsOverMax() {
        if(currHealth > MAX_HEALTH) {
            currHealth = MAX_HEALTH;
        }
    }

    private boolean isMaxHealth(int health) {
        return health == MAX_HEALTH;
    }
}
