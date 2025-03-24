package src;

import javax.swing.JOptionPane;

public class TicTacToeGame {
    private TicTacToeBoard board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private TicTacToeFrame frame;
    private int moveCount;
    private final int MOVES_FOR_WIN = 5;
    private final int MOVES_FOR_TIE = 9;

    public TicTacToeGame(TicTacToeFrame frame) {
        this.frame = frame;
        board = new TicTacToeBoard();
        playerX = new Player("Player X", "X");
        playerO = new Player("Player O", "O");
        currentPlayer = playerX;
        moveCount = 0;
    }

    public void handleMove(int row, int col, String player) {
        if (board.isValidMove(row, col)) {
            Move move = new Move(currentPlayer, row, col);
            board.placeMove(move);
            frame.updateTile(row, col, currentPlayer.getSymbol());
            moveCount++;

            if (moveCount >= MOVES_FOR_WIN && board.checkWin(currentPlayer.getSymbol(), player)) {
                board.display(); // For console debugging
                JOptionPane.showMessageDialog(frame, currentPlayer.getName() + " wins!");
                frame.resetGame();
            } else if (moveCount == MOVES_FOR_TIE && board.isFull()) {
                board.display(); // For console debugging
                JOptionPane.showMessageDialog(frame, "It's a Tie!");
                frame.resetGame();
            } else {
                switchPlayer();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Tile already taken!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void resetGame() {
        board.clearBoard();
        currentPlayer = playerX;
        moveCount = 0;
    }

    public void displayBoard() {
        board.display();
    }
}