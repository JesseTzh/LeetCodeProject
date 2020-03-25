import sun.java2d.SurfaceDataProxy;

import java.util.ArrayList;
import java.util.List;

public class SurfaceAreaOf3DShapes {

    public static void main(String[] args) {
        int[][] input_1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] input_2 = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        int[][] input_3 = {{1, 0}, {0, 2}};
        int[][] input_4 = {{1, 2}, {3, 4}};
        int[][] input_5 = {{2}};
        List<int[][]> inputList = new ArrayList<>();
        inputList.add(input_1);
        inputList.add(input_2);
        inputList.add(input_3);
        inputList.add(input_4);
        inputList.add(input_5);
        int[] outputs = {32, 46, 16, 34, 10};
        int count = 0;
        for (int[][] input : inputList) {
            int output = outputs[count];
            if (surfaceArea(input) == output) {
                System.out.println("测试用例第" + count + "例成功！");

            } else {
                System.out.println("测试用例第" + count + "例失败！！\n输出结果为：" + surfaceArea(input));
                System.out.println("预期结果为：" + output);
                //break;
            }
            count++;
        }
    }

    public static int surfaceArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    int blockedArea = 0;
                    //同一格中方块叠加所被遮挡的面积
                    if (grid[i][j] > 1) {
                        blockedArea += 2 * (grid[i][j] - 1);
                    }
                    //诸多相邻的情况
                    if (j >= 1) {
                        blockedArea += 2 * Math.min(grid[i][j - 1], grid[i][j]);
                    }
                    if (i >= 1) {
                        blockedArea += 2 * Math.min(grid[i - 1][j], grid[i][j]);
                    }
                    result += 6 * grid[i][j] - blockedArea;
                }
            }
        }
        return result;
    }
}
