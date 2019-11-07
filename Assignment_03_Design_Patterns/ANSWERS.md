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