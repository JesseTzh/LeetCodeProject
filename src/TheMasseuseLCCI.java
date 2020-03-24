public class TheMasseuseLCCI {
    public static void main(String[] args) {
        int[] argOne = {1,2,3,1};
        int[] argTwo = {2,7,9,3,1};
        int[] argThree = {2,1,4,5,3,1,1,3};
        if(massage(argOne) == 4 && massage(argTwo) == 12 && massage(argThree) == 12){
            System.out.println("成功！");
        }else {
            System.out.println("失败！！");
        }
    }
    //空间复杂度O(1)
    public static int massage(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i = 0;i < nums.length; i++){
            int c = Math.max(a, b+nums[i]);
            //b储存上次循环得出的结果
            b = a;
            //a储存本次循环得出的结果
            a = c;
        }
        return a;
    }
}
