import java.util.Scanner;

public class tictactoe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();

        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;
        int moves = 0;

        while (!gameOver) {
            displayBoard();

            int row, col;

            do {
                System.out.println("Player " + currentPlayer + ", enter row (0, 1, 2) and column (0, 1, 2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!isValidMove(row, col));

            board[row][col] = currentPlayer;
            moves++;

            if (checkWin(row, col)) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (moves == 9) {
                displayBoard();
                System.out.println("It's a tie!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move. Row and column must be between 0 and 2.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("Invalid move. Cell is already occupied.");
            return false;
        }
        return true;
    }

    private static boolean checkWin(int row, int col) {
  
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true;
        }
       
        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            return true;
        }
  
        if (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        } 
        return false;
    }
}
