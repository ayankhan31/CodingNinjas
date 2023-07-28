package tictactoe;

public class Board {
    private char board[][];
    private int boardSize = 3;
    private char p1Symbol, p2Symbol;
    //count of number of cells that are filled
    private int count;
    //constant marked as empty
    private static final char EMPTY = ' ';
    public static final int PLAYER1WINS = 1;
    public static final int PLAYER2WINS = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALIDMOVE = 5;

    public Board(char p1Symbol, char p2Symbol) {
        count = 0;
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = EMPTY;
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    public int move(char ch, int x, int y) {
        if (x < boardSize && y < boardSize && x >= 0 && y >= 0) {
            if (board[x][y] == ' ') {
                board[x][y] = ch;
                count++;

            } else {
                return INVALIDMOVE;
            }
            //Row check
            if (board[x][0] == board[x][1] && board[x][0] == board[x][2] && board[x][0] != ' ') {
                if (board[x][0] == p1Symbol) {
                    return 1;
                } else {
                    return 2;
                }
            }

            //Column check
            if (board[0][y] == board[1][y] && board[0][y] == board[2][y] && board[0][y] != ' ') {
                if (board[0][y] == p1Symbol) {
                    return 1;
                } else {
                    return 2;
                }
            }
            //Diagonal Check
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
                if (board[0][0] == p1Symbol) {
                    return 1;
                } else {
                    return 2;
                }
            }
            //Other diagonal Check
            if (board[0][2] == board[2][2] && board[0][2] == board[2][0] && board[0][2] != ' ') {
                if (board[0][2] == p1Symbol) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        if (count <= 9) {
            return INCOMPLETE;
        } else {
            return DRAW;
        }
    }

    public void print() {
        System.out.println("-------------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------");
    }
}
