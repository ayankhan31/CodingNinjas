package tictactoe;
//---------------TIC TAC TOE----------//
/* 1) Player -> name, symbol, no of games won, etc
    2) Board -> P1 symbol, P2 symbol, size, count(no of cells filled already)
    3) Tic tac toe -> Manager -> P1. P2, Board
 */
public class Player {
    private String name;
    private char symbol;
    public Player(String name, char symbol){
        setName(name);
        setSymbol(symbol);
    }
    public void setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }
    }
    public String getName(){
        return this.name;
    }
    public void setSymbol(char symbol){
        if(symbol != '\0'){
            this.symbol = symbol;
        }
    }
    public char getSymbol(){
        return this.symbol;
    }
}
