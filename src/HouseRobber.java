public class HouseRobber {
    public static void main(String[] args) {
        int[] argOne = {1, 2, 3, 1};
        int[] argTwo = {2, 7, 9, 3, 1};
        int[] argThree = {2, 1, 4, 5, 3, 1, 1, 3};
        if (robber(argOne) == 4 && robber(argTwo) == 12 && robber(argThree) == 12) {
            System.out.println("最优解法成功！");
        } else {
            System.out.println("最优解法失败！！");
        }
        if (stupidRobber(argOne) == 4 && stupidRobber(argTwo) == 12 && stupidRobber(argThree) == 12) {
            System.out.println("笨贼解法成功！");
        } else {
            System.out.println("笨贼解法失败！！");
        }
    }
    //最优解法，空间复杂度O（1）
    public static int robber(int[] nums) {
        int CurrMaxValue = 0;
        int PreMaxValue = 0;
        for(int num : nums){
            int TempValue = CurrMaxValue;
            CurrMaxValue = Math.max(CurrMaxValue,PreMaxValue + num);
            PreMaxValue = TempValue;
        }
        return CurrMaxValue;
    }
    //空间复杂度O（n）的解法
    public static int stupidRobber(int[] nums){
        int length = nums.length;
        //先处理特殊情况
        if (length == 0){
            return 0;
        }else if (length == 1){
            return nums[0];
        }
        //建立数组存储遍历结果
        int[] sumResult = new int[length];
        //为前两项特殊情况赋值
        sumResult[0] = nums[0];
        sumResult[1] = Math.max(nums[0],nums[1]);
        //从第三项开始遍历
        for (int i = 2; i < length; i++) {
            sumResult[i] = Math.max(sumResult[i - 1],sumResult[i - 2] + nums[i]);
        }
        return sumResult[length - 1];
    }
}
