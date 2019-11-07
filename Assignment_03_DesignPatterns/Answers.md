Group 10 Markdown Answer File
---------------------------------
####Part 1:

Observer Pattern:

After every move, each square is checked and adjusted accordingly, depending on the user input. So instead of iterating
through the board matrix after every move, we created an Observable Object which all the squares are dependent on. 
Whenever the observable changes its state (meaning whenever the move function is called inside the Move class), all 
subscribed squares are notified and updated accordingly in terms of Piece placement on the square. This helps us to 
encapsulate parts of our code as it is not any longer necessary to loop over the board matrix in order to access every
single square and update it. We can just subscribe new squares to the Move class and whenever there is movement, the 
move class will trigger the state update in each subscribed square.

Class Diagram: [click here](https://github.com/niddhog/BINF4241-Group10/blob/master/Assignment_03_DesignPatterns/ObserverDiagramm.jpeg)

Sequence Diagram: [click here](https://github.com/niddhog/BINF4241-Group10/blob/master/Assignment_03_DesignPatterns/ObserverSequenceDiagramm.jpg)
##


Iterator Pattern:

We decided to add an iteration Pattern into our Chess game in order to encapsulate iteration. As there are four 
instances of for loops inside the check class that each need to iterate over the whole chessboard we decided to 
encapsulate that process by implementing an iterator pattern. That way, when changing the game board design at a later 
stage, we do not have to adjust four different loops separately but can just simply access the BoardIterator Class in 
order to change the behavior for traversing the ChessBoard.

Class Diagram: [click here](https://github.com/niddhog/BINF4241-Group10/blob/master/Assignment_03_DesignPatterns/IteratorDiagram.jpeg)

Sequence Diagram: [click here](https://github.com/niddhog/BINF4241-Group10/blob/master/Assignment_03_DesignPatterns/IteratorSequenceDiagram.jpg)
##
####Part 2:
##
####Part 3:

Score Board:

The Scoreboard has been implemented as Singleton Class. It is instantiated before the Game-Loop starts via the 
getInstance() method. It is then called each time a Player enters a Move Command, thus it is first send to the
move() function of the move Object. The move Object is an observable object which was instantiated from the Move Class
and part of the Observer Pattern we introduced in Part 1 of this Task. Thus, in order to correctly update the Scoreboard,
each subscriber to the move Object, namely each Square on the board, will get notified about the incoming move. Inside
the update() function of each square Object, the Scoreboard gets updated in case there was an enemy Piece on the 
square which now will be eaten. The point addition is handled inside the Scoreboard Class itself and can be accessed
from everywhere via updateScoreBoard.

##

ChessPieceIterator:

This Pattern makes use of the already implemented Iterator Pattern from Part 1 of this Exercise. At start up in the
ChessGame Class, before the main loop starts, a chessPieceIterator object is created by accessing the createIterator()
method of the board object. The createIterator() method returns an Iterator that iterates over a List of Squares,
as in our implementation of Chess, Squares are the objects that hold and allow access to Pieces. It iterates over
the first and second row of the board, as well as over the 7 and 8 row of the board in order to access all squares
with Pieces on them, according to the initial Setup of Chess. We implemented a Translator Class that translates
the SquareCoordinates into Chess Notation (example X:0 Y:0 will be printed as a1). All Figures and their locations
are printed this way until the Iterator reaches its Endpoint, meaning hasNext() returns false.