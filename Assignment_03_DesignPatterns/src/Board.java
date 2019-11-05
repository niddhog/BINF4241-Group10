import java.util.ArrayList;
import java.util.List;

public class Board{
    private Square[][] board = new Square[8][8];
    private ArrayList<Square> squareArrayList = new ArrayList<>();

    public Board(Move move){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j] = new Square(i, j);
                move.registerObserver(board[i][j]);
                squareArrayList.add(board[i][j]);
            }
        }
    }


    Square[][] getBoard() {
        return board;
    }

    void printBoard(){
        System.out.println("\n");
        for(int i=7; i>-1; i--){
            System.out.println(i+1 + "  " + board[0][i] + board[1][i] + board[2][i] + board[3][i] + board[4][i]
                    + board[5][i] + board[6][i] + board[7][i]);
        }
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
    }

    public boolean isSomethingBetween(Piece currPiece, Coordinates start, Coordinates end){
        if(currPiece.getPieceType() == PieceType.KNIGHT){  //knights can jump
            return false;
        }
        int yDif = end.getY() - start.getY();
        int xDif = end.getX() - start.getX();
        int diag;
        int vert;
        int hor;
        boolean isUpOrRight = (xDif > 0 || yDif > 0); //WORKS AS INTENDED
        if(isUpOrRight){
            diag = 1; // starts not on the square itself but on one in the wished direction
            vert = 1;
            hor = 1;
        }
        else{
            diag = -1;
            vert = -1;
            hor = -1;
        }

        if(xDif == yDif){                                                           //diagonal check
            while(start.getX() + diag != end.getX()) {
                if (board[start.getX() + diag][start.getY() + diag].getPieceOnSquare() != null) {
                    return true;
                }
                if(isUpOrRight){
                    diag++;
                }
                else{
                    diag--;
                }
            }
            return false;
        }
        if((start.getX() == end.getX() && start.getY() != end.getY())){             // vertical check
            while(start.getY() + vert != end.getY()){
                if(board[start.getX()][start.getY() + vert].getPieceOnSquare() != null){
                    return true;
                }
                if(isUpOrRight){
                    vert++;
                }
                else{
                    vert--;
                }
            }
            return false;
        }
        if ((start.getY() == end.getY() && start.getX() != end.getX())){            // horizontal check
            while(start.getX()- hor != end.getX()){
                if(board[start.getX()+hor][start.getY()].getPieceOnSquare() != null){
                    return true;
                }
                if(isUpOrRight){
                    hor++;
                }
                else{
                    hor--;
                }
            }
            return false;
        }
        return false; // safety
    }


    public ArrayList<Square> getSquareArray(){
        return this.squareArrayList;
    }


    public Iterator createIterator(){
        return new BoardIterator(this.squareArrayList);
    }
}
