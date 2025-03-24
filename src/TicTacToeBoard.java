package src;

public class TicTacToeBoard {
    private static final int ROW = 3;
    private static final int COL = 3;
    private String[][] board;

    public TicTacToeBoard() {
        board = new String[ROW][COL];
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" ");
    }

    public void placeMove(Move move) {
        if (isValidMove(move.getRow(), move.getCol())) {
            board[move.getRow()][move.getCol()] = move.getPlayer().getSymbol();
        }
    }

    public String getSymbolAt(int row, int col) {
        if (row >= 0 && row < ROW && col >= 0 && col < COL) {
            return board[row][col];
        }
        return null;
    }

    public boolean isFull() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(String playerSymbol, String player) {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            // Check columns
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }


    public String[][] getBoard() {
        return board;
    }

    public void display() {
    }
}