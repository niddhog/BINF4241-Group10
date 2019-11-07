# Design Patterns
## Part 01

### Singleton on ChessBoard class

#### Why?
Both players can only access to the same instance and has restricted instructions to change its attributes. At the moment it changes nothing but to ensure the privacy of the class. Let's suppose, we would extend the chess game to a software running on a server and for two given players, so two clients are available on different operating systems. Thus, the program has to deal with the accessing of the two players by given unique chess board.

#### How?
The player can only move a piece by enter its current position to a valid position. Cause the single thread we solve the accessing of the board by "synchronized" function at the moment ChessBoard returns its object.

```java
public class Board{
    private static Square[][] board = new Square[8][8];

    public static synchronized Square[][] getBoard() {
        return board;
    }
```

### Iterator over the PieceSet for ChessBoard

#### Why?
Mostly for checking any collisions we iterate over all pieces. It's  often used, because the validMove of the pieces is biggest part of the game rules. Depending on the implementation the iterator over the pieceset gives us more flexibility for later additional developement on the program,

#### How?
We create a seperate iterator class, which can take an array or a list type and its content only of type "Piece" is to return the single pieces with with their attributes for the current game state.

```java
public class PieceSet {
    private Piece[] pieceList;
    private PieceColor setColor;
    .
    .
    .
        public Iterator createIterator(){
        return new setIterator(pieceList);
    }
}
```

```java
public class InitBoard { //puts pieces of the players on the board

    public static void init(Board board, Player p1, Player p2){
        .
        .
        .
               Iterator blackIterator = blackSet.createIterator();
        Iterator whiteIterator = whiteSet.createIterator();

        //setup White pieces, works
        for(int i=0; i<2; i++){
            for(int j=0; j<8; j++) {
                if (whiteIterator.hasNext()) {
                    board.getBoard()[j][i].setPieceOnSquare(whiteIterator.next());
                }
            }
        }

        //setup Black pieces, works

        for(int i=0; i<2; i++){
            for(int j=0; j<8; j++) {
                if(blackIterator.hasNext()) {
                    board.getBoard()[7 - j][7 - i].setPieceOnSquare(blackIterator.next());
                }
            }
        }
    }
}

```

#### class diagram

[class diagram](https://github.com/niddhog/BINF4241-Group10/blob/master/Assignment_03_Design_Patterns/class-diagram.jpeg)


#### sequence diagram 

[sequence diagram](https://github.com/niddhog/BINF4241-Group10/blob/master/Assignment_03_Design_Patterns/sequence-diagram.jpeg)

Both diagrams contains all necessary parts for Part 1 and Part 2 of the assignment.

## Part 03

### Superqueen and Archbishop(white) in ChessBoard class

First we add some necessary interfaces, so we are able to use the unique validMove() method of the piece subclasses for our new classes. We don't need to know how the specific validMove()works, we only merge them to get our "new" validMove() methods. <br />
We solved the teleport() method by extending the collision test inside ChessGame for the Superqueen case, because teleport can't eat a piece and is depending on the current board state.<br/>
```java
if(gameBoard.isSomethingBetween(currPiece, start, end))  {
    if(currPiece.getPieceType() != PieceType.SUPERQUEEN) {
        if(Board.getBoard()[end.getX()][end.getY()].getPieceOnSquare()==null) {
                            throwColision();
                            continue;
                        }
                    }
                }

 if(!(currPiece.validMove(start.getX(), start.getY(), end.getX(), end.getY(), capture)) && !(currPiece.getPieceType() == PieceType.SUPERQUEEN
                        && gameBoard.getBoard()[end.getX()][end.getY()].getPieceOnSquare()==null)){

                    throwPieceCantMoveLikeThat();
                    continue;
                }

```
Mostly the adapter isn´t changed that much from the design pattern but the new classes extend the abstract "Piece" class, because the collision test looks for the specific piece subclass. 
```java
public class Superqueen extends Piece implements PieceInterface{}

public class Archbishop extends Piece{}

```

Well, be careful, it works for both players, but implemented is at the moment only fot the white player to test whether the older version of our Chess game still works. Feel free to change the piece subclasses from the black Set in the instantiation of the piece sets inside of the "PieceSet" class.
```java
    public PieceSet(PieceColor color){
        this.setColor = color;
        if (color == PieceColor.WHITE){
            Piece a1 = new Rook(color);
            Piece h1 = new Rook(color);
            Piece b1 = new Knight(color);
            Piece g1 = new Knight(color);
            Bishop sampleBishop = new Bishop(color);
            Knight sampleKnight = new Knight(color);
            Piece c1 = new Archbishop(sampleBishop, sampleKnight);
            Piece f1 = new Archbishop(sampleBishop, sampleKnight);
            Queen sampleQueen = new Queen(color);
            Piece d1 = new Superqueen(sampleQueen);
            Piece e1 = new King(color);

            Piece a2 = new Pawn(color);
            Piece b2 = new Pawn(color);
            Piece c2 = new Pawn(color);
            Piece d2 = new Pawn(color);
            Piece e2 = new Pawn(color);
            Piece f2 = new Pawn(color);
            Piece g2 = new Pawn(color);
            Piece h2 = new Pawn(color);
            pieceList = new Piece[]{a1, b1, c1, d1, e1, f1, g1, h1,
                    a2, b2, c2, d2, e2, f2, g2, h2};

        }
        else
        {
            Bishop sampleBishop = new Bishop(color);
            Knight sampleKnight = new Knight(color);
            Queen sampleQueen = new Queen(color);
            Piece a8 = new Rook(color);
            Piece h8 = new Rook(color);
            Piece b8 = new Knight(color);
            Piece g8 = new Knight(color);
            Piece c8 = new Bishop(color);
            Piece f8 = new Bishop(color);
            Piece e8 = new Queen(color);
            Piece d8 = new King(color);

            Piece a7 = new Pawn(color);
            Piece b7 = new Pawn(color);
            Piece c7 = new Pawn(color);
            Piece d7 = new Pawn(color);
            Piece e7 = new Pawn(color);
            Piece f7 = new Pawn(color);
            Piece g7 = new Pawn(color);
            Piece h7 = new Pawn(color);
            pieceList = new Piece[]{a8, b8, c8, d8, e8, f8, g8, h8,
                    a7, b7, c7, d7, e7, f7, g7, h7};
        }


    }

```

