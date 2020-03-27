import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4, 4, 3, 2, 1}, {1, 1, 1, 2, 2, 2, 3, 3}, {1}, {1, 1}, {1, 1, 2, 2, 2, 2}};
        boolean[] outputs = {true, false, false, true, true};
        for (int i = 0; i < inputs.length; i++) {
            if (hasGroupsSizeX(inputs[i]) == outputs[i]) {
                System.out.println("成功！");
            } else {
                System.out.println("失败！实际输出:" + hasGroupsSizeX(inputs[i]));
            }
            System.out.println("--------");
        }
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        // 计数
        int[] counter = new int[10000];
        for (int num : deck) {
            counter[num]++;
        }
        // 迭代求多个数的最大公约数
        int maxGcd = 0;
        for (int cnt : counter) {
            maxGcd = getGcd(maxGcd, cnt);
            if (maxGcd == 1) { // 如果某步中最大公约数是1，直接返回false
                return false;
            }
        }
        return maxGcd >= 2;
    }

    private static int getGcd(int maxGcd, int currentNum) {
        return currentNum == 0 ? maxGcd : getGcd(currentNum, maxGcd % currentNum);
    }
}
