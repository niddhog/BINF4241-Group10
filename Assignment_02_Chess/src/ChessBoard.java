public class ChessBoard {
    private Square[][] squares = new Square[8][8]; //Matrix for holding 64 squares 8x8
    private Piece[] pieceSets; //Array for storing PieceSets of Players (Black Set or White Set)
    private PieceColor pieceSetOnTop; //Which color plays on the Top Side of the Board

    public ChessBoard(PieceColor color){
        this.pieceSetOnTop = color;
    }

    public void create(){ //creates initial chess field and places Player 1 on top of the field
        for(int i = 0; i < squares.length; i++){
            for(int j = 0; j < squares.length; j++){
                squares[i][j] = new Square(i,j); //place all the squares at the right position in the board Grid
            }
        }
        switch (pieceSetOnTop){
            case BLACK: //Player 1 is Black

                break;
            case WHITE: //Player 1 is White

                break;
            default:
                System.out.println("Cannot setup Board, unspecified Player Color");
                break;
        }
    }

    public Square getSquare(int i, int j){              //getter for square
        return squares[i][j];
    }

    public void display(){//first Piece Class has to be specified in order to place Pieces
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("8 |   |   |   |   |   |   |   |   | 8");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("7 |   |   |   |   |   |   |   |   | 7");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("6 |   |   |   |   |   |   |   |   | 6");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("5 |   |   |   |   |   |   |   |   | 5");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("4 |   |   |   |   |   |   |   |   | 4");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("3 |   |   |   |   |   |   |   |   | 3");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("2 |   |   |   |   |   |   |   |   | 2");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("1 |   |   |   |   |   |   |   |   | 1");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
    }
}

