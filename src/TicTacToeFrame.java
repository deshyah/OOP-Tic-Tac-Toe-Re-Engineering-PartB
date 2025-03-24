package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    private JPanel mainPnl;
    private JPanel boardPnl;
    private JPanel quitPnl;
    private TicTacToeButton[][] tiles;
    private JButton quitBtn;
    private final int ROW = 3;
    private final int COL = 3;
    private TicTacToeGame game;
    private String currentPlayer = "X"; // Declare currentPlayer here


    public TicTacToeFrame() {
        setTitle("Tic Tac Toe Game");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new TicTacToeGame(this);

        mainPnl = new JPanel(new BorderLayout());
        add(mainPnl);

        createBoardPanel();
        mainPnl.add(boardPnl, BorderLayout.CENTER);

        createQuitPanel();
        mainPnl.add(quitPnl, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void createBoardPanel() {
        boardPnl = new JPanel(new GridLayout(ROW, COL));
        tiles = new TicTacToeButton[ROW][COL];
        TileClickListener listener = new TileClickListener();

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                tiles[row][col] = new TicTacToeButton(row, col);
                tiles[row][col].setText(" ");
                tiles[row][col].addActionListener(listener);
                boardPnl.add(tiles[row][col]);
            }
        }
    }

    private void createQuitPanel() {
        quitPnl = new JPanel();
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitPnl.add(quitBtn);
    }

    public void updateTile(int row, int col, String symbol) {
        tiles[row][col].setText(symbol);
        tiles[row][col].setEnabled(false);
    }

    public void resetGame() {
        int playAgain = JOptionPane.showConfirmDialog(null, "Play another game?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (playAgain == JOptionPane.YES_OPTION) {
            game.resetGame();
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    tiles[row][col].setText(" ");
                    tiles[row][col].setEnabled(true);
                }
            }
        } else {
            System.exit(0);
        }
    }

    private class TileClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TicTacToeButton tile = (TicTacToeButton) e.getSource();
            game.handleMove(tile.getRow(), tile.getCol(), currentPlayer);
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeFrame());
    }
}
