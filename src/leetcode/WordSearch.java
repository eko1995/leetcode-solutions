package leetcode;

/**
 * @author eko
 * @date 2018/10/25 9:27 AM
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        boolean res = new WordSearch().exist(board, word);
        System.out.println(res);
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(i, j, chars, 0, board)) return true;
            }
        }
        return false;

    }

    public boolean check(int row, int col, char[] chars, int index, char[][] board) {
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0) return false;
        if (board[row][col] != chars[index]) return false;
        if (index == chars.length - 1) return true;
        char c = board[row][col];
        board[row][col] = '0';
        boolean flag = check(row + 1, col, chars, index + 1, board) || check(row - 1, col, chars, index + 1, board) || check(row, col - 1, chars, index + 1, board) || check(row, col + 1, chars, index + 1, board);
        board[row][col] = c;

        return flag;
    }
}
