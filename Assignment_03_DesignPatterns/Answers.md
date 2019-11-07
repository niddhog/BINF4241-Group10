Group 10 Markdown Answer File
---------------------------------
Part 1:

Observer Pattern:

After every move, each square is checked and adjusted accordingly, depending on the user input. So instead of iterating
through the board matrix after every move, we created an Observable Object which all the squares are dependent on. 
Whenever the observable changes its state (meaning whenever the move function is called inside the Move class), all 
subscribed squares are notified and updated accordingly in terms of Piece placement on the square. This helps us to 
encapsulate parts of our code as it is not any longer necessary to loop over the board matrix in order to access every
single square and update it. We can just subscribe new squares to the Move class and whenever there is movement, the 
move class will trigger the state update in each subscribed square.

Iterator Pattern:

We decided to add an iteration Pattern into our Chess game in order to encapsulate iteration. As there are four 
instances of for loops inside the check class that each need to iterate over the whole chessboard we decided to 
encapsulate that process by implementing an iterator pattern. That way, when changing the game board design at a later 
stage, we do not have to adjust four different loops separately but can just simply access the BoardIterator Class in 
order to change the behavior for traversing the ChessBoard.
