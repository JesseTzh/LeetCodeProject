public class PalindromeNumber {
    public static void main(String[] args) {
        int[] inputs = {121, -121, 10};
        boolean[] outputs = {true, false, false};
        for (int i = 0; i < 3; i++) {
            System.out.println("第" + i + "例：");
            if (isPalindrome(inputs[i]) == outputs[i]) {
                System.out.println("成功！");
                System.out.println("---------------");
            } else {
                System.out.println("失败！\n预期输出：" + outputs[i] + "\n实际输出：" + isPalindrome(inputs[i]));
                System.out.println("---------------");
            }
        }
    }

    public static boolean isPalindrome(int x) {
        int saveX = x;
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            int palindromeNum = 0;
            while (x != 0) {
                palindromeNum = x % 10 + palindromeNum * 10;
                x = x / 10;
            }
            if (palindromeNum == saveX){
                return true;
            }else {
                return false;
            }
        }
    }
}
