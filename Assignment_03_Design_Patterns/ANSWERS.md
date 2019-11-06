# Design Patterns
## Part 01

### Singleton on ChessBoard class

Why?
both players can only access to the same instance and has restricted
instructions to change its attributes. At the moment it changes nothing but to ensure the privacy of the class. Let's suppose, we would extend the chess game to a software running on a server and for two given players, so two clients are available on different operating systems. Thus, the program has to deal with the accessing of the two players by given unique chess board.

how
the player can only move a piece by enter its current position to a valid position. Cause the single thread we solve the accessing of the board by "synchronized" function at the moment ChessBoard returns its object.

class diagram

sequence diagram 

### Iterator over the PieceSet for ChessBoard

why?
Mostly for checking any collisions we iterate over all pieces. It's  often used, because the validMove of the pieces is most part of the game rules. Depending on the implementation the iterator over the pieceset gives us more flexibility for later additional developement

how?
create a seperate iterator class, which can take an array or a list type and its content only of type "Piece" is to return the single pieces with with their attributes for the current game state

class diagram

sequence diagram 

## Part 02



## Part 03