package tictactoe;
import java.sql.SQLOutput;
import java.util.*;
public class TicTacToe {
    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        //Take player's input
        player1 = takePlayerInput(++numPlayers);
        player2 = takePlayerInput(++numPlayers);
        while(player1.getSymbol() == player2.getSymbol()){
            System.out.println("Symbol already taken, enter different symbol!");
            player2.setSymbol(sc.next().charAt(0));
        }

        //create the board
        board = new Board(player1.getSymbol(),player2.getSymbol());

        // Play the game
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE || status == Board.INVALIDMOVE){
            if(player1Turn){
                System.out.println("Player 1 - "+player1.getName()+"'s turn");
                //coordinates
                System.out.println("Enter x: ");
                int x = sc.nextInt();
                System.out.println("Enter y: ");
                int y = sc.nextInt();
                //this function will make the move and tell the status of the game.
                //return int - 1 if player 1 won, 2 if 2 won , 3 if draw, 4 if incomplete, 5 if invalid
                status = board.move(player1.getSymbol(),x, y);
                if(status == Board.INVALIDMOVE){
                    System.out.println("Invalid move! Please try again!! ");
                    continue;
                }
            }
            else{
                System.out.println("Player 2 - "+player2.getName()+"'s turn");
                System.out.println("Enter x: ");
                int x = sc.nextInt();
                System.out.println("Enter y: ");
                int y = sc.nextInt();
                //this function will make the move and tell the status of the game.
                //return int - 1 if player 1 won, 2 if 2 won , 3 if draw, 4 if incomplete, 5 if invalid
                status = board.move(player2.getSymbol(),x, y);
                if(status == Board.INVALIDMOVE){
                    System.out.println("Invalid move! Please try again!! ");
                    continue;
                }
            }
            player1Turn = !player1Turn;
            board.print();
        }
            if(status == Board.PLAYER1WINS){
                System.out.println("Player 1 - " +player1.getName()+ " wins!!!");
            }
            else if(status == Board.PLAYER2WINS){
                System.out.println("Player 2 - " +player2.getName()+ " wins!!!");
            }
            else{
                System.out.println("Draw!");
            }
    }


    private Player takePlayerInput(int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player "+num+" name: ");
        String name = sc.nextLine();
        System.out.println("Enter Player "+num+" Symbol: ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;

    }
}
