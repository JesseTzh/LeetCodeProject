public class AvailableCapturesForRook {
    public static void main(String[] args) {
        char [][] input = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};        int output = 3;
        if (numRookCaptures(input) == output) {
            System.out.println("成功！");
        } else {
            System.out.println("失败！输出结果为:" + numRookCaptures(input));
        }
    }

    public static int numRookCaptures(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'R') {
                    continue;
                } else {
                    int temp = i;
                    while (temp > 0) {
                        temp--;
                        if (board[temp][j] == 'B') {
                            break;
                        } else if (board[temp][j] == 'p') {
                            result++;
                            break;
                        }
                    }
                    temp = i;
                    while (temp < board.length-1) {
                        temp++;
                        if (board[temp][j] == 'B') {
                            break;
                        } else if (board[temp][j] == 'p') {
                            result++;
                            break;
                        }
                    }
                    temp = j;
                    while (temp > 0) {
                        temp--;
                        if (board[i][temp] == 'B') {
                            break;
                        } else if (board[i][temp] == 'p') {
                            result++;
                            break;
                        }
                    }
                    temp = j;
                    while (temp < board[i].length-1) {
                        temp++;
                        if (board[i][temp] == 'B') {
                            break;
                        } else if (board[i][temp] == 'p') {
                            result++;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
