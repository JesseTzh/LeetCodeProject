import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] answer = {0, 1};
        if (Arrays.equals(twoSum(nums, target), answer)) {
            System.out.println("暴力法成功！");
        } else {
            System.out.println("暴力法失败！");
        }
        if (Arrays.equals(hashTwoSum(nums, target), answer)) {
            System.out.println("哈希法成功！");
        } else {
            System.out.println("哈希法失败！");
        }
    }

    //暴力法
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        return result;
    }

    //哈希法:核心思路是将Hash表的Key和Value换位，但此方法不适用参数只有两个且相同的情况
    public static int[] hashTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        //首先，将传入的数组存储在一个哈希表中
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            //差值
            int dValue = target - nums[i];
            if (hashMap.containsValue(dValue) && hashMap.get(dValue) != i) {
                result[1] = i;
                result[0] = hashMap.get(dValue);
            }
        }
        return result;
    }
}
