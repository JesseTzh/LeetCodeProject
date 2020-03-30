public class ClockwiseMatrix {
    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[] output = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        int[] result = spiralOrder(input);
        System.out.println("--------------------------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int resultLength = matrix[0].length * matrix.length;
        int[] matrixResult = new int[resultLength];
        //System.out.println("数组长度" + resultLength);
        int matrixCount = 0;
        //第i圈
        for (int i = 0; i < matrix.length; i++) {
            //上边,首位存在，末尾每圈 - i
            for (int a = i; a < matrix[i].length - i; a++) {
                matrixResult[matrixCount] = matrix[i][a];
                System.out.println(matrixResult[matrixCount]);
                matrixCount++;
                if (matrixCount == resultLength){
                    return matrixResult;
                }
            }
            System.out.println("--------上边结束--------");
            //右边，首位被上边占用一个 + 1，末位每圈 - i
            for (int b = i + 1; b <= matrix.length - i -1; b++) {
                System.out.println("test:::" + b);
                matrixResult[matrixCount] = matrix[b][matrix[i].length - i - 1];
                System.out.println(matrixResult[matrixCount]);
                matrixCount++;
                if (matrixCount == resultLength){
                    return matrixResult;
                }
            }
            System.out.println("--------右边结束--------");
            //下边index从大到小，首位被右边占用 - 1，末位每圈 - i
            for (int c = matrix[i].length - i - 2; c >= i; c--) {
                System.out.println("下边c：" + c);
                matrixResult[matrixCount] = matrix[matrix.length - i - 1][c];
                System.out.println(matrixResult[matrixCount]);
                matrixCount++;
                if (matrixCount == resultLength){
                    return matrixResult;
                }
            }
            System.out.println("--------下边结束--------");
            //左边index从大到小，首位被下边占用 - 1
            for (int d = matrix.length - i - 2; d > i; d--) {
                matrixResult[matrixCount] = matrix[d][i];
                System.out.println(matrixResult[matrixCount]);
                matrixCount++;
                if (matrixCount == resultLength){
                    return matrixResult;
                }
            }
            System.out.println("--------左边结束--------");
        }
        return matrixResult;
    }
}
