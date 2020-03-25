public class ReverseInteger {
    public static void main(String[] args) {
        int[] input = {123, -123, 120, 1534236469};
        int[] output = {321, -321, 21, 0};
        for (int i = 0; i < input.length; i++) {
            if (reverse(input[i]) != output[i]) {
                System.out.println("第" + i + "次运行失败！结果" + reverse(input[i]));
            }
        }
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = x % 10 + result * 10;
            if (result % 10 != x % 10) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }
}
