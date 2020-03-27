public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input1 = {"flower","flow","flight"};
        String[] input2 = {"aa","a","flight"};
        String[] input3 = {"aa","a"};
        String[] input4 = {"a","aa"};
        String result = "fl";
        System.out.println( "结果为："+ longestCommonPrefix(input4));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 0) {
            return "";
        }
        int i;
        for (i = 0; i < strs[0].length(); i++) {
            System.out.println("当前i值为：" + i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j - 1].length() || i >= strs[j].length()) {
                    return strs[0].substring(0, i);
                }
                System.out.println("当前j值为：" + j);
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
