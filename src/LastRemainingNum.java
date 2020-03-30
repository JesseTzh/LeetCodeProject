import java.util.ArrayList;
import java.util.List;

public class LastRemainingNum {
    public static void main(String[] args) {
        int[][] inputs = {{5, 3}, {10, 17}, {1, 1}};
        int[] outputs = {3, 2, 0};
        for (int i = 0; i < inputs.length; i++) {
            int result = lastRemaining(inputs[i][0], inputs[i][1]);
            if (result == outputs[i]) {
                System.out.println("成功！");
            } else {
                System.out.println("失败！");
                System.out.println("预期结果：" + outputs[i]);
                System.out.println("实际结果：" + result);
            }
            System.out.println("-------------------------------");
        }
    }

    public static int lastRemaining(int n, int m) {
        List<Integer> numList = new ArrayList();
        for (int i = 0; i < n; i++) {
            numList.add(i);
        }
        removeM(numList, m);
        return numList.get(0);
    }

    private static void removeM(List<Integer> numList, int m) {
        if (numList.size() == 1) {
            return;
        }
        int removeNum;
        removeNum = m;
        while (numList.size() > 1){
            while (removeNum > numList.size()) {
                removeNum = removeNum - numList.size();
            }
            System.out.println("移除了：" + numList.get(removeNum - 1));
            numList.remove(removeNum - 1);
            removeNum = removeNum - 1 +m;
        }
    }
}
