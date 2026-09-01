class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for ( int c = 0; c < 9; c++) {
                if (board[r][c] == '.'){
                    continue;
                }

                char value = board[r][c];
                int sqidx = (r / 3) * 3 + (c / 3);

                if  (rows[r].contains(value) ||
                     cols[c].contains(value) ||
                     squares[sqidx].contains(value)){
                     return false;
                }
                
                rows[r].add(value);
                cols[c].add(value);
                squares[sqidx].add(value);
            }
        }
        return true;
    }
}