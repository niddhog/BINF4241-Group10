# JavaTests
## Part 01

### 



#### 



## Part 02

To fix the code efficiently we start to fix the methods with the least dependencies. Therefore, we start the methods inside of the "GameBoard" class. 

##### maskTwice testcase

```java
    if (board[row][col] != null) {
      return true;
    } else {
      board[row][col] = player;
      return false;
    }
```

The mark() methods tests, whether the position is already marked or not. If it isn´t marked, we mark the position and return true, else false. So we correct the condition to return a true statement:

```java
       if (board[row][col] != null) {
      return false;
    } else {
      board[row][col] = player;
      return true;
    }
```

In the testcase getOpenPositions() we iterate over all positions und add all empty ones.
##### getOpenPositions() testcase
```java
  public List<Position> getOpenPositions() {
    ArrayList<Position> positions = new ArrayList<Position>();
    for (int row = 0; row < ROWS; row++) {
      for (int col = 1; col < COLS; col++) {
        if (board[row][col] == null) {
          positions.add(new Position(row, col));
        }
      }
    }
    return positions;
  }
```

We can see in the code above, it begins to iterate at the second coloumn position instead at the first, so we would miss some positions. So, we change "1" to "0".
```java
        for (int col = 0; col < COLS; col++) {
```
Afterwards all test cases of "GameBoardTest" passed by two corrections.



##### isOverWin

```java
  public boolean hasWin(Player player) {
    for (int i = 0; i < 3; i++) {
      if (completesRow(player, i) || completesColumn(player, i)) {
        return false;
      }
    }
    return completesDiagonal(player);
  }
```

```java
      if (completesRow(player, i) || completesColumn(player, i)) {
        return true;
      }
```

##### hasWinDiagonal

```java
  private boolean completesDiagonal(Player player) {
    Player center = board.getMark(1, 1);
    if (player != center) {
      return false;
    }
    return (board.getMark(0, 0) == center && center == board.getMark(1, 2))
        || (board.getMark(0, 2) == center && center == board.getMark(2, 0));
  }
```

```java
    return (board.getMark(0, 0) == center && center == board.getMark(2, 2))
        || (board.getMark(0, 2) == center && center == board.getMark(2, 0));
```
##### startingPlayerIsX()
```java
  public Player getCurrentPlayer() {
    Player randomPlayer = Player.O;
    currentPlayer = randomPlayer;
    return currentPlayer;
  }
```
```java
  public Player getCurrentPlayer() {
    return currentPlayer;
  }
```
```java

```
```java

```
```java

```

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

